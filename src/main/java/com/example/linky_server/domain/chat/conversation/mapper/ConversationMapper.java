package com.example.linky_server.domain.chat.conversation.mapper;

import com.example.linky_server.app.mapper.MapperConfig;
import com.example.linky_server.app.mapper.MapperEntity;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ConversationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface ConversationMapper  {
    ConversationMapper INSTANCE = Mappers.getMapper(ConversationMapper.class);
    ConversationResponse toDTO(ConversationEntity entity);
}
