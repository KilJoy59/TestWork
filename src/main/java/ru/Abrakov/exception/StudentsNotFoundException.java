package ru.Abrakov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentsNotFoundException extends RuntimeException {

    public StudentsNotFoundException(String message) {
        super(message);
    }
}
