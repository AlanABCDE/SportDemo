package com.noob.sportsdemo.Controller;

import com.google.gson.Gson;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.service.impl.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.noob.sportsdemo.common.Result;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Resource
    private IEventService eventService;
    @Autowired
    public EventMapper eventMapper;
    public Gson gson=new Gson();

    @GetMapping("/getEvent")
    public String getUser(){
        List<Event> events = eventMapper.selectList(null);
        System.out.println(events);
        return gson.toJson(events);
    }
    @DeleteMapping ("/deleteEvent")
    public Result deleteEvent(@PathVariable Integer eid){
        eventService.removeById(eid);
        return Result.success();
    }
}
