package ru.project.notes.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionMessage {
    ID_NOT_FOUND("id is not found", HttpStatus.NOT_FOUND);

    private String message;
    private HttpStatus status;
}
