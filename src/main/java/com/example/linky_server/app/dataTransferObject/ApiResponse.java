package com.example.linky_server.app.dataTransferObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    @JsonIgnore
    HttpStatus httpStatus = HttpStatus.OK;
    @JsonIgnore
    HttpHeaders headers;

    int code = 200;

    Boolean success = true;

    String message;

    T data;

    Map<String, Object> errors;

    Date timestamp = new Date();

    public static <T> ApiResponse<T> build() {
        return new ApiResponse<>();
    }

    @PostConstruct
    private void init() {
        httpStatus = HttpStatus.OK;
        code = httpStatus.value();
        errors = new HashMap<String, Object>();
    }

    public ApiResponse<T> withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public ApiResponse<T> withHttpStatus(HttpStatus status) {
        this.httpStatus = status;
        this.code = status.value();
        return this;
    }

    public ApiResponse<T> withCode(int code) {
        this.code = code;
        return this;
    }

    public ApiResponse<T> withData(T data) {
        this.data = data;
        return this;
    }

    public ApiResponse<T> withHttpHeaders(HttpHeaders headers) {
        this.headers = headers;
        return this;
    }

    public ApiResponse<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public ApiResponse<T> withErrors(Map<String, Object> errors) {
        this.errors = errors;
        return this;
    }

    public ResponseEntity<?> toEntity() {
        if (success) {
            return new ResponseEntity<>(data, headers, httpStatus);
        }
        return new ResponseEntity<>(this, headers, httpStatus);
    }
}
