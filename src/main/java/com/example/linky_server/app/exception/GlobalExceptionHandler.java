package com.example.staynex_server.common.exception;
import com.example.staynex_server.common.contant.ResponseCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.security.access.AccessDeniedException;

import com.example.staynex_server.common.dataTransferObject.response.ApiResponse;
import com.example.staynex_server.common.dataTransferObject.response.ApiResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException e) {
        ApiResponseCode code = e.getResponseCode();
        ApiResponse<?> errorResponse;

        if (code != null) {
            Map<String, Object> errors = new HashMap<>();
            errors.put("type", code.getType());
            errorResponse = ApiResponse.<Void>build()
                    .withCode(code.getCode())
                    .withErrors(errors)
                    .withMessage(e.getMessage())
                    .withSuccess(false);
            return ResponseEntity
                    .status(code.getCode())
                    .body(errorResponse);
        }
        Map<String, Object> errors = new HashMap<>();
        errors.put("error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        errorResponse = ApiResponse.<Void>build()
                .withCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withErrors(errors)
                .withMessage(e.getMessage())
                .withSuccess(false);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", ResponseCode.VALIDATION_ERROR.getType());
        errors.put("errors", ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage()
                )));

        ApiResponse<?> errorResponse = ApiResponse.<Void>build()
                .withCode(HttpStatus.BAD_REQUEST.value())
                .withErrors(errors)
                .withMessage("Validation failed")
                .withSuccess(false);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("type", ResponseCode.ACCESS_DENIED.getType());
        ApiResponse<?> errorResponse = ApiResponse.<Void>build()
                .withCode(HttpStatus.FORBIDDEN.value())
                .withErrors(errors)
                .withMessage(ex.getMessage())
                .withSuccess(false);
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }
}

