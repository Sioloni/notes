package ru.project.notes.controller.advice;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.project.notes.model.dto.ApplicationExceptionDto;
import ru.project.notes.model.dto.ValidationDto;
import ru.project.notes.model.exception.ApplicationException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@CrossOrigin
@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ApplicationExceptionDto handlerApplicationException(ApplicationException ex) {
        return new ApplicationExceptionDto(ex.getExceptionMessage().getStatus().toString(),
                ex.getExceptionMessage().getMessage());
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
