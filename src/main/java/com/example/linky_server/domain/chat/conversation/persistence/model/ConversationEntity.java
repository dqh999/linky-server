package com.example.linky_server.domain.chat.conversation.persistence.model;

import com.example.linky_server.app.model.BaseEntity;
import com.example.linky_server.domain.chat.conversation.contant.ConversationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tbl_chat_conversations")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConversationEntity extends BaseEntity {
    @Enumerated(EnumType.STRING)
    ConversationType type;
    String name;
    String thumbnail;
    @Column(name = "creator_id")
    String creatorId;
}
