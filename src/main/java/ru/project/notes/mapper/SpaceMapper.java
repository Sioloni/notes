package ru.project.notes.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.project.notes.model.dto.RecordGetDto;
import ru.project.notes.model.dto.SpaceDto;
import ru.project.notes.model.entity.Record;
import ru.project.notes.model.entity.Space;
import ru.project.notes.repository.RecordRepository;
import ru.project.notes.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SpaceMapper {
    private final UserService userService;
    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;


    public SpaceDto toDto(Space entity) {
        return new SpaceDto
                (
                        entity.getId(),
                        entity.getTitle(),
                        entity.getUser().getId(),
                        entity.getRecords().stream().map(recordMapper::toGetDto).collect(Collectors.toList())
                );
    }

    public Space toEntity(SpaceDto dto) {
        return new Space
                (
                        dto.getId(),
                        dto.getTitle(),
                        userService.getEntity(dto.getUserId()),
                        new HashSet<>(recordRepository.findAllById(dto.getRecord().stream().map(RecordGetDto::getId).collect(Collectors.toList())))
                );
    }

    public List<Space> toEntity(List<SpaceDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<SpaceDto> toDto(List<Space> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }


    public Space update(Space entity, SpaceDto dto) {
        Space updateEntity = toEntity(dto);
        System.out.println(updateEntity.toString());
        if (updateEntity.getTitle() != null && !updateEntity.getTitle().isEmpty()) {
            entity.setTitle(updateEntity.getTitle());
        }
        if (updateEntity.getUser() != null) {
            entity.setUser(userService.getEntity(updateEntity.getUser().getId()));
        }
        if (updateEntity.getRecords() != null) {
            entity.getRecords().addAll(updateEntity.getRecords());
        }
        return entity;

    }
}
