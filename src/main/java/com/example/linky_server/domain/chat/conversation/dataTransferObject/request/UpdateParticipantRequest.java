package com.example.linky_server.domain.chat.conversation.dataTransferObject.request;

import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateParticipantRequest {
    private String id;
    private String nickName;
    private ParticipantRole role;
}
