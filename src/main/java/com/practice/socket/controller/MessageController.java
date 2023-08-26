package com.practice.socket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @MessageMapping("/message") /* 클라이언트가 "/{destination prefix}/message" 로 메시지를 보내면 여기에 연결됨 */
    @SendTo("/topic/message") /* "/topic/message"를 구독하고 있는 사용자들에게 모두 메시지가 전송됨 */
    public String broadCasting(String message) {
        log.info("=> {}", message);
        return message;
    }
}
