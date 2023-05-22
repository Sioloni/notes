package ru.project.travel.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.travel.dto.TourDto;
import ru.project.travel.service.TourService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/user/tour")
@RequiredArgsConstructor
public class TourController {
    private final TourService service;


    @GetMapping
    public List<TourDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public TourDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody TourDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody TourDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
