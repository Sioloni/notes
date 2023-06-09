package ru.project.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.notes.mapper.SpaceMapper;
import ru.project.notes.model.dto.SpaceDto;
import ru.project.notes.model.entity.Space;
import ru.project.notes.model.exception.ApplicationException;
import ru.project.notes.model.exception.ExceptionMessage;
import ru.project.notes.repository.SpaceRepository;
import ru.project.notes.service.SpaceService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {
    private final SpaceRepository repository;
    private final SpaceMapper mapper;


    @Override
    public Space getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND));
    }

    @Override
    public List<SpaceDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public SpaceDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND)));
    }

    @Override
    public void create(SpaceDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, SpaceDto dto) {
        Space entity = mapper.toEntity(get(id));
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
