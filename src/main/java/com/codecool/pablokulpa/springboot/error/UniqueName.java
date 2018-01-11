package com.codecool.pablokulpa.springboot.error;

import com.codecool.pablokulpa.springboot.log.Log;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UniqueName extends ResponseEntityExceptionHandler {

    private Log log;

    public UniqueName(Log log) {
        this.log = log;
        log.setLogger(UniqueName.class);
    }

    @PostMapping(path = "")
    @ResponseStatus(value=HttpStatus.CONFLICT,
            reason="Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){
        log.getLog(DataIntegrityViolationException.class.toString());

    }

}