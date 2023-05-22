package ru.project.travel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationExceptionDto {
    private String status;
    private String desc;
}
