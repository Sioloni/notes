package ru.project.travel.service;

import ru.project.travel.dto.BasketDto;

import java.util.List;

public interface BasketService {

    List<BasketDto> get();

    BasketDto get(Long id);

    void create(BasketDto dto);

    void update(Long id, BasketDto dto);

    void delete(Long id);
}
