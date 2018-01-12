package com.codecool.pablokulpa.springboot.error;

import com.codecool.pablokulpa.springboot.log.Log;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalError extends ResponseEntityExceptionHandler {

    private Log log;

    public GlobalError(Log log) {
        this.log = log;
        log.setLogger(GlobalError.class);
    }

    @PostMapping(path = "")
    @ResponseStatus(value=HttpStatus.CONFLICT,
            reason="Data integrity violation")
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict(){
        log.errorLog(DataIntegrityViolationException.class.toString());
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
        ResponseError error = new ResponseError("Resource not found", "Resource with given id don't exists");
        log.errorLog("Resource with given id don't exists");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}