package com.carrot.data;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class ResponseError {
    private String message;
    private Integer code;
    private String url;
    private String exception;

    public ResponseError(HttpStatus status, HttpServletRequest request, String exception) {
        this.message = status.getReasonPhrase();
        this.code = status.value();
        this.url = request.getRequestURI();
        this.exception = exception;
    }
}
