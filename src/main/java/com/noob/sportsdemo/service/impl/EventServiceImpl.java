package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.service.IEventService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {
    @Resource
    private EventMapper eventMapper;
    @Override
    public List<Event> selectByEvent(String eventHolder) {
        return eventMapper.selectByEventHolder(eventHolder);
    }
}
