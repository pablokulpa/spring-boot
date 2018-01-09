package com.codecool.pablokulpa.springboot.error;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UniqueName extends ResponseEntityExceptionHandler {


    @PostMapping(path = "")
    @ResponseStatus(value=HttpStatus.CONFLICT,
            reason="Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){

    }

}