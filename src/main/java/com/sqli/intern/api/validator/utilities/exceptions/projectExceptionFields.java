package com.sqli.intern.api.validator.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
public class projectExceptionFields {
    private final String message;
    private final HttpStatus httpStatus;
}
