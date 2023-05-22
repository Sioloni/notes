package ru.project.travel.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.travel.dto.BasketDto;
import ru.project.travel.service.BasketService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/user/tour/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService service;


    @GetMapping
    public List<BasketDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public BasketDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody BasketDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody BasketDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}