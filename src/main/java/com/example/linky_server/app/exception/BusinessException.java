package com.example.linky_server.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class BusinessException extends RuntimeException {
    com.example.staynex_server.common.dataTransferObject.response.ApiResponseCode responseCode;
    public BusinessException(com.example.staynex_server.common.dataTransferObject.response.ApiResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}