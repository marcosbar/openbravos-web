package com.mgb.view.controller;

import com.mgb.common.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mgb on 03/04/2016.
 */
@ControllerAdvice
public class ExceptionHandlerController {

        @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Not found")
        @ExceptionHandler(NotFoundException.class)
        public void notFound(HttpServletRequest req, Exception exception) {
            // TODO: logging?
        }
}
