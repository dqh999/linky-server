package com.example.linky_server.domain.chat.conversation.configuration;

import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import com.example.linky_server.domain.chat.conversation.service.IConversationTypeHandler;
import com.example.linky_server.domain.chat.conversation.service.impl.PrivateConversationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


@Configuration
@RequiredArgsConstructor
public class ConversationConfig {
    private final PrivateConversationHandler privateConversationHandler;
    @Bean
    public Map<ConversationType,IConversationTypeHandler> conversationTypeHandler(){
        return Map.of(
                ConversationType.PRIVATE, privateConversationHandler
        );
    }
}
