package com.retailstore.exceptions;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.retailstore.dto.response.ExceptionResponseDto;
import com.retailstore.util.ValidationUtil;
/**
 * @author mohammadnaushad
 *
 */
@ControllerAdvice
public class ExceptionHandlingController {
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> invalidInput(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        ExceptionResponseDto response = new ExceptionResponseDto();
        response.setErrorCode("Validation Error");
        response.setErrorMessage("Invalid inputs.");
        response.setErrors(ValidationUtil.fromBindingErrors(result));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> resourceNotFound(ResourceNotFoundException ex) {
    	ExceptionResponseDto response = new ExceptionResponseDto();
        response.setErrorCode("Not Found");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({SQLException.class,HibernateException.class})
	public  ResponseEntity<ExceptionResponseDto> handleSQLException(Exception ex){
    	ExceptionResponseDto response = new ExceptionResponseDto();
        response.setErrorCode("Database Error");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
    @ExceptionHandler({Exception.class})
	public  ResponseEntity<ExceptionResponseDto> handleException(Exception ex){
    	ExceptionResponseDto response = new ExceptionResponseDto();
        response.setErrorCode("There is a problem! Please contact administrator!");
        response.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}