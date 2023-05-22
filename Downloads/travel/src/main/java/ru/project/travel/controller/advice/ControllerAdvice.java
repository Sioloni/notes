package ru.project.travel.controller.advice;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.project.travel.dto.ApplicationExceptionDto;
import ru.project.travel.dto.ValidationDto;
import ru.project.travel.exception.ApplicationException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler
    public ApplicationExceptionDto handlerApplicationException(ApplicationException ex) {
        return new ApplicationExceptionDto(ex.getMassage().getStatus().toString(), ex.getMassage().getDesc());
    }

    @ExceptionHandler
    public List<ValidationDto> handledValidField(ConstraintViolationException ex) {
        List<ValidationDto> validations = ex.getConstraintViolations().stream()
                .map(s -> new ValidationDto(s.getPropertyPath().toString(), s.getMessage())).toList();
        return validations;
    }

    @ExceptionHandler
    public List<ValidationDto> handledValidField(MethodArgumentNotValidException ex) {
        List<ValidationDto> validations = ex.getBindingResult().getFieldErrors().stream()
                .map(s -> new ValidationDto(s.getField(), s.getDefaultMessage())).toList();
        return validations;
    }


}
