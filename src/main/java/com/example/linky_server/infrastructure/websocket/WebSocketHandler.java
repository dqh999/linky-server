package com.example.linky_server.infrastructure.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WebSocketHandler {
    private final SimpMessagingTemplate template;
    public void sendMessage(String destination, String type,Object message) {
        MessagePayload<Object> payload = MessagePayload.builder()
                .type(type)
                .data(message)
                .build();
        template.convertAndSend(destination, payload);
    }
}
