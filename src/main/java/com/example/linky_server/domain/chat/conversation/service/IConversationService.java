package com.example.linky_server.domain.chat.conversation.service;

import com.example.linky_server.app.security.UserPrincipal;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.AddParticipantRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.request.CreateConversationRequest;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ConversationResponse;
import com.example.linky_server.domain.chat.conversation.dataTransferObject.response.ParticipantResponse;

import java.util.List;


public interface IConversationService {
    ConversationResponse createConversation(UserPrincipal userRequest,
                                            CreateConversationRequest request);

    ParticipantResponse addParticipant(UserPrincipal userRequest,
                                       AddParticipantRequest request);

}
