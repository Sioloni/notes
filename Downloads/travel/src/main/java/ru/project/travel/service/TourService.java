package ru.project.travel.service;

import ru.project.travel.dto.TourDto;
import ru.project.travel.entity.Tour;

import java.util.List;

public interface TourService {

    List<Tour> get(List<Long> id);

    List<TourDto> get();

    TourDto get(Long id);

    void create(TourDto dto);

    void update(Long id, TourDto dto);

    void delete(Long id);
}
