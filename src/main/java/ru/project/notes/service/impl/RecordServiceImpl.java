package ru.project.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.notes.mapper.RecordMapper;
import ru.project.notes.mapper.SpaceMapper;
import ru.project.notes.model.dto.RecordDto;
import ru.project.notes.model.dto.SpaceDto;
import ru.project.notes.model.entity.Record;
import ru.project.notes.model.entity.Space;
import ru.project.notes.model.exception.ApplicationException;
import ru.project.notes.model.exception.ExceptionMessage;
import ru.project.notes.repository.RecordRepository;
import ru.project.notes.repository.impl.RecordSpaceRepositoryImpl;
import ru.project.notes.service.RecordService;
import ru.project.notes.service.SpaceService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository repository;
    private final SpaceService service;
    private final RecordMapper mapper;
    private final SpaceMapper spaceMapper;
    private final RecordSpaceRepositoryImpl recordSpaceRepository;


    @Override
    public List<RecordDto> get(Long spaceId) {
        SpaceDto spaceDto = service.get(spaceId);
        return mapper.toDto(repository.findAllById(spaceDto.getRecordId()));
    }

    @Override
    public RecordDto get(Long spaceId, Long id) {
        SpaceDto spaceDto = service.get(spaceId);
        return mapper.toDto(repository.findAllById(spaceDto.getRecordId())
                .stream()
                .filter(s -> s.getId().equals(id)).findAny()
                .orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND)));
    }

    @Override
    public void create(Long spaceId, RecordDto dto) {
        Space space = spaceMapper.toEntity(service.get(spaceId));
        space.setRecords(Set.of(repository.save(mapper.toEntity(dto))));
        service.update(spaceId, spaceMapper.toDto(space));
    }

    @Override
    public void update(Long spaceId, Long id, RecordDto dto) {
        Record entity = mapper.toEntity(get(spaceId, id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        recordSpaceRepository.deleteObjectById(id);
    }
}
