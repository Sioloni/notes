package ru.project.travel.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.project.travel.dto.UserDto;
import ru.project.travel.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;


    @GetMapping
    public List<UserDto> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable Long id) {
        return service.get(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody UserDto dto) {
        service.create(dto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody UserDto dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
