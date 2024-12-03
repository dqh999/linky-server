package com.example.linky_server.infrastructure.websocket;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class MessagePayload<T> {
    private String type;
    private T data;
}
