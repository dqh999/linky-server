package com.example.linky_server.domain.chat.conversation.mapper;

import com.example.linky_server.app.mapper.MapperConfig;
import com.example.linky_server.app.mapper.MapperEntity;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;
import com.example.linky_server.domain.chat.conversation.persistence.model.ParticipantEntity;
import org.mapstruct.Mapper;

@Mapper(
        config = MapperConfig.class
)
public interface ParticipantMapper extends MapperEntity<ParticipantEntity, ParticipantResponse> {
}
