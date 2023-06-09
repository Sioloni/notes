package ru.project.notes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.notes.model.dto.RecordDto;
import ru.project.notes.service.RecordService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/api/v1/user/space/{spaceId}/record")
@RequiredArgsConstructor
public class RecordController {
    private final RecordService service;


    @GetMapping
    public List<RecordDto> get(@PathVariable Long spaceId) {
        return service.get(spaceId);
    }

    @GetMapping("/{id}")
    public RecordDto get(@PathVariable Long spaceId, @PathVariable Long id) {
        return service.get(spaceId, id);
    }

    @PostMapping
    public void create(@PathVariable Long spaceId, @RequestBody RecordDto dto) {
        service.create(spaceId, dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long spaceId, @PathVariable Long id, @Valid @RequestBody RecordDto dto) {
        service.update(spaceId, id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
