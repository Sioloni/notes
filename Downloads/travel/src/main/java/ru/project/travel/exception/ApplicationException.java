package ru.project.travel.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends Error{
    private ExceptionMassage massage;
}
