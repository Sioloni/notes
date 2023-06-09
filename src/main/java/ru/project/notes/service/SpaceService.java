package ru.project.notes.service;


import ru.project.notes.model.dto.SpaceDto;
import ru.project.notes.model.entity.Space;

import java.util.List;

public interface SpaceService {

    Space getEntity(Long id);
    List<SpaceDto> get();

    SpaceDto get(Long id);

    void create(SpaceDto dto);

    void update(Long id, SpaceDto dto);

    void delete(Long id);
}
