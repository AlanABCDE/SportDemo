package com.noob.sportsdemo.controller;

import com.google.gson.Gson;
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
}
