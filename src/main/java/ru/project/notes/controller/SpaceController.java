package ru.project.notes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.notes.model.dto.SpaceDto;
import ru.project.notes.service.SpaceService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@Validated
@RestController
@RequestMapping("/api/v1/user/space")
@RequiredArgsConstructor
public class SpaceController {
    private final SpaceService service;


    @GetMapping
    public List<SpaceDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public SpaceDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody SpaceDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody SpaceDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
