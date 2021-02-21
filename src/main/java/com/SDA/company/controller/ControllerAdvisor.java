package com.SDA.company.controller;

import com.SDA.company.exception.CompanyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<Object> companyNotFoundException(CompanyNotFoundException exception){
        Map<String,Object> responseBody = new LinkedHashMap<>();
        responseBody.put("Message",exception.getLocalizedMessage());
        responseBody.put("Timestamp", LocalDateTime.now()); //<- data si ora la care a fost declansata exceptia

        return new ResponseEntity<>(responseBody, HttpStatus.I_AM_A_TEAPOT);
    }
}
