package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.common.Result;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.service.impl.EventServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Resource
    private EventServiceImpl eventService;

    @Resource
    public EventMapper eventMapper;

    public Gson gson = new Gson();

    @GetMapping("/getEvent")
    public String getUser() {
        List<Event> events = eventMapper.selectList(null);
        System.out.println(events);
        return gson.toJson(events);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.success(eventService.removeById(id)) ;
    }

    @PostMapping("/holdEvent")
    public Result holdEvent(@RequestBody Event event){
        eventService.saveOrUpdate(event);
        return Result.success();
    }
    @GetMapping ("/selEvent/{eventHolder}")
    public Result selEvent(@PathVariable String eventHolder) {
        return Result.success(eventService.selectByEvent(eventHolder));

    }
}
