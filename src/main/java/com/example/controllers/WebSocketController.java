package com.example.controllers;

import com.example.dto.PostDto;
import com.example.dto.UserDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.util.HtmlUtils;

public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/message")
    public PostDto message(UserDto userDto) throws Exception {
        return new PostDto("Привет, " + HtmlUtils.htmlEscape(userDto.getUsername()));
    }
}
