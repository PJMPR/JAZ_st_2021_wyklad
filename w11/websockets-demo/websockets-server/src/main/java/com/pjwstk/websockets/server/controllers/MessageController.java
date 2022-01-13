package com.pjwstk.websockets.server.controllers;


import com.pjwstk.websockets.contract.MyMessage;
import com.pjwstk.websockets.contract.OutMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
public class MessageController {

    @MessageMapping("/chat/{userid}")
    @SendTo("/topic/messages/{userid}")
    public OutMessage send(MyMessage msg, String userid){
      log.info("Got message {} {}", msg.getName(), msg.getMessage());
      String time = new SimpleDateFormat("HH:mm").format(new Date());
      return new OutMessage(msg.getName(), msg.getMessage(), time);
    }
}
