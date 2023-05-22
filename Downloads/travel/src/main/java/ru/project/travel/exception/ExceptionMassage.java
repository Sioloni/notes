package ru.project.travel.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ExceptionMassage {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "id is not found");


    private HttpStatus status;
    private String desc;

}
