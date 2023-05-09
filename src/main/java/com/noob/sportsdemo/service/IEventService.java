package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.noob.sportsdemo.entity.Event;

import java.util.List;

public interface IEventService extends IService<Event> {
    List<Event> selectByEvent(String eventHolder);

    void joinEvent(Integer id);
}
