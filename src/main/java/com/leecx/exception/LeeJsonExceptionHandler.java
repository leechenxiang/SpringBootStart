package com.leecx.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.leecx.pojo.LeeJSONResult;

//@RestControllerAdvice
public class LeeJsonExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public LeeJSONResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	
    	e.printStackTrace();
        return LeeJSONResult.errorException(e.getMessage());
    }
    
}
