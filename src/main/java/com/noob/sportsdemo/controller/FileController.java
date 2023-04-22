package com.noob.sportsdemo.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Files;
import com.noob.sportsdemo.mapper.FileMapper;
import com.noob.sportsdemo.service.IFileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("E:\\Code\\Driving\\SportDemo\\files")
    private String fileUploadPath;

    @Resource
    private FileMapper fileMapper;
    @Resource
    private IFileService fileService;

    /**
     * 文件上传接口
     * @param file 前端传递过来的文件
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();//获取文件名称
        String type = FileUtil.extName(originalFilename);//文件类型
        long size = file.getSize();

        // 定义一个文件唯一的标识码（文件名称)
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;//文件名称+后缀--例 1.jpg
        File uploadFile = new File(fileUploadPath + fileUUID);

        String url;
        // 判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }   //获取文件MD5
        String md5 = SecureUtil.md5(file.getInputStream());
        // 从数据库查询是否存在相同的记录
        Files dbFiles = getFileByMd5(md5);
        if (dbFiles != null) { // 文件已存在
            url = dbFiles.getUrl();
        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            url = "http://localhost:9090/file/" + fileUUID;
        }
        // 存储数据库
        Files saveFile = new Files();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size/1024);
        saveFile.setUrl(url);
        saveFile.setMd5(md5);
        fileMapper.insert(saveFile);
        return url;
    }
    /**
     * 通过文件的md5查询文件
     * @param md5
     * @return
     */
    private Files getFileByMd5(String md5) {
        // 查询文件的md5是否存在
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        List<Files> filesList = fileMapper.selectList(queryWrapper);
        return filesList.size() == 0 ? null : filesList.get(0);//如何查询到的文件为0则返回null否则返回有md5文件索引的第一条数据
    }



    //    ----------------------------------------
    @GetMapping("/page")    //    分页模糊查询 --mybatis-plus
    public IPage<Files> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String name //可以不输入,但是为空是不能拼接条件否则无法查出数据
                                  ){
        IPage<Files> page=new Page<>(pageNum,pageSize);//分页
        QueryWrapper<Files> queryWrapper=new QueryWrapper<>();//查询数据
        if(!"".equals(name)){
            queryWrapper.like("name",name);//条件
        }
        queryWrapper.orderByAsc("id");
        IPage<Files> filesIPage = fileService.page(page, queryWrapper);
        return filesIPage;
    }


    @DeleteMapping("/{id}")
    public Result delRete(@PathVariable Integer id){
        return Result.success(fileService.removeById(id));
    }
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) { //删除所有数据 --// [1,2,3]
        return Result.success(fileService.removeByIds(ids));
    }

    @PostMapping("/update")
    public Result update(@RequestBody Files files) {
        return Result.success(fileMapper.updateById(files));
    }

}
