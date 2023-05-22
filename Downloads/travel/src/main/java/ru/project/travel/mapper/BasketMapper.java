package ru.project.travel.mapper;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.project.travel.dto.BasketDto;
import ru.project.travel.entity.Basket;
import ru.project.travel.entity.Tour;
import ru.project.travel.service.TourService;
import ru.project.travel.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BasketMapper {
    private final TourService tourService;
    private final UserService userService;


    public Basket toEntity(BasketDto dto) {
        return new Basket
                (
                        dto.getId(),
                        userService.getEntity(dto.getUserId()),
                        new HashSet<>(tourService.get(dto.getTourId())),
                        dto.getTotalPrice()
                );
    }

    public BasketDto toDto(Basket entity) {
        return new BasketDto
                (
                        entity.getId(),
                        entity.getUser().getId(),
                        entity.getTours().stream().map(Tour::getId).collect(Collectors.toList()),
                        entity.getTotalPrice()
                );
    }

    public List<Basket> toEntity(List<BasketDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<BasketDto> toDto(List<Basket> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }


    public Basket update(Basket entity, BasketDto dto) {
        if (dto.getUserId() != null && !dto.getUserId().toString().isEmpty()) {
            entity.setUser(userService.getEntity(dto.getUserId()));
        }
        if (dto.getTourId() != null && !dto.getTourId().isEmpty()) {
            entity.setTours(new HashSet<>(tourService.get(dto.getTourId())));
        }
        return entity;
    }

}










