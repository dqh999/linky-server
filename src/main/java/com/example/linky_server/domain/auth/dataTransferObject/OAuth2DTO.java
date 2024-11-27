package com.example.linky_server.domain.auth.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OAuth2DTO {
    String sub;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    String email;
}
