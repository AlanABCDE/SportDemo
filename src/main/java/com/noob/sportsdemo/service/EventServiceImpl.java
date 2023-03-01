package com.noob.sportsdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.service.impl.IEventService;

public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements IEventService {
}
