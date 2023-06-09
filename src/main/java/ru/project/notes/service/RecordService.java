package ru.project.notes.service;


import ru.project.notes.model.dto.RecordDto;

import java.util.List;
import java.util.Set;

public interface RecordService {


    List<RecordDto> get(Long spaceId);

    RecordDto get(Long spaceId, Long id);

    void create(Long spaceId, RecordDto dto);

    void update(Long spaceId, Long id, RecordDto dto);

    void delete(Long id);
}
