package com.example.linky_server.app.contant;

import com.example.linky_server.app.dataTransferObject.ApiResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode implements ApiResponseCode {
    ACCESS_DENIED("ACCESS_DENIED", 403),
    VALIDATION_ERROR("VALIDATION_ERROR", 422),

    NO_CHANGES_MADE("NO_CHANGES_MADE", 400);

    private final String type;
    private final Integer code;
}
