package ru.project.notes.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends Error{
    private ExceptionMessage exceptionMessage;
}
