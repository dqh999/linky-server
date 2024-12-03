package com.example.linky_server.app.exception;

import com.example.linky_server.app.dataTransferObject.ApiResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    ApiResponseCode responseCode;
    public BusinessException(ApiResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}