package com.maple.originmapleapp.config.exception;

import com.maple.originmapleapp.config.exception.exceptionList.CustomApiException;
import com.maple.originmapleapp.config.exception.exceptionList.CustomValidationException;
import com.maple.originmapleapp.dto.response.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHanlder {

    /*
        Exception 핸들링을 위한 컨트롤러
        추가적으로 생성하셔서 사용하셔도 됩니다.
        exceptionList 에 원하는 Custom Exception 을 생성 후 핸들러에 추가해주시면 됩니다.

     */


    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> validationException(CustomValidationException e) {
        return new ResponseEntity<>(new DefaultResponse<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {
        return new ResponseEntity<>(new DefaultResponse<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }
}
