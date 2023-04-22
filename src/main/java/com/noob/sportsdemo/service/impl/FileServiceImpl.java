package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.noob.sportsdemo.entity.Files;
import com.noob.sportsdemo.mapper.FileMapper;
import com.noob.sportsdemo.service.IFileService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements IFileService {

}
