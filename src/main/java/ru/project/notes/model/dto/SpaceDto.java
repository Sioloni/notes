package ru.project.notes.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpaceDto {
    private Long id;

    private String title;

    private Long userId;

    private List<RecordGetDto> record = new ArrayList<>();
}








