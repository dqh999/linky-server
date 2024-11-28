package com.example.linky_server.domain.auth.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoogleOAuth2DTO {
    String sub;
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    String email;
    @Column(name = "date_of_birth")
    LocalDateTime dateOfBirth;
    String gender;
}
