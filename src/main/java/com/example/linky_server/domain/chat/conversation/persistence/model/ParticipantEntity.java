package com.example.linky_server.domain.chat.conversation.persistence.model;

import com.example.linky_server.common.model.BaseEntity;
import com.example.linky_server.domain.chat.conversation.contant.ParticipantRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_chat_conversations")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParticipantEntity extends BaseEntity {
    @Column(name = "conversation_id")
    String conversationId;
    @Column(name = "account_id")
    String accountId;
    @Enumerated(EnumType.STRING)
    ParticipantRole role;
}
