package ru.Abrakov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Project TestWork
 * Created by End on июнь, 2020
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class StudentExistException extends RuntimeException {

    public StudentExistException(String message) {
        super(message);
    }
}
