package com.example.teamapp.controllers;

import com.example.teamapp.dto.PostDto;
import com.example.teamapp.dto.UserDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public PostDto message(UserDto userDto) throws Exception{
        return new PostDto("Hello, " + HtmlUtils.htmlEscape(userDto.getUsername()));
    }
}
