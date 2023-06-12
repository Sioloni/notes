package ru.project.notes.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.project.notes.model.dto.RecordDto;
import ru.project.notes.model.dto.RecordGetDto;
import ru.project.notes.model.entity.Record;
import ru.project.notes.repository.RecordRepository;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RecordMapper {
    private final RecordRepository repository;


    public RecordDto toDto(Record entity) {
        return new RecordDto
                (
                        entity.getId(),
                        entity.getTitle(),
                        entity.getTags(),
                        entity.getDate(),
                        entity.getText(),
                        entity.getRecords().stream().map(Record::getId).collect(Collectors.toList())
                );
    }

    public RecordGetDto toGetDto(Record entity){
        return new RecordGetDto
                (
                        entity.getId(),
                        entity.getTitle()
        );
    }




    public Record toEntity(RecordDto dto) {
        return new Record
                (
                        dto.getId(),
                        dto.getTitle(),
                        dto.getTags(),
                        dto.getDate(),
                        dto.getText(),
                        new HashSet<>(repository.findAllById(dto.getRecordIds()))
                );
    }

    public List<Record> toEntity(List<RecordDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<RecordDto> toDto(List<Record> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }


    public Record update(Record entity, RecordDto dto) {
        Record updateEntity = toEntity(dto);
        if (updateEntity.getTitle() != null && !updateEntity.getTitle().isEmpty()) {
            entity.setTitle(updateEntity.getTitle());
        }
        if (updateEntity.getTags() != null) {
            entity.setTags(updateEntity.getTags());
        }
        if (updateEntity.getText() != null && !updateEntity.getText().isEmpty()) {
            entity.setText(updateEntity.getText());
        }
        if (updateEntity.getRecords() != null) {
            entity.setRecords(new HashSet<>(repository.findAllById
                            (
                                    updateEntity.getRecords()
                                            .stream()
                                            .map(Record::getId)
                                            .collect(Collectors.toList())
                            )
                    )
            );
        }
        return entity;
    }
}
