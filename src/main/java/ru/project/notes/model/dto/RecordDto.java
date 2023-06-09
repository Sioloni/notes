package ru.project.notes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {
    private Long id;

    private String title;

    private List<String> tags = new ArrayList<>();

    private LocalDateTime date = LocalDateTime.now();

    private String text;

    private List<Long> recordIds = new ArrayList<>();
}






