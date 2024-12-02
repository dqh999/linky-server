package com.example.linky_server.infrastructure.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MessagePayload<T> {
    private String type;
    private T data;
}
