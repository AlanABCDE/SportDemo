package com.noob.sportsdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.noob.sportsdemo.entity.Event;
import com.noob.sportsdemo.entity.Message;
import com.noob.sportsdemo.mapper.EventMapper;
import com.noob.sportsdemo.mapper.MessageMapper;
import com.noob.sportsdemo.service.IEventService;
import com.noob.sportsdemo.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
}
