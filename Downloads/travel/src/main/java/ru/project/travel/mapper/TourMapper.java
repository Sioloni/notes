package ru.project.travel.mapper;


import org.springframework.stereotype.Component;
import ru.project.travel.dto.TourDto;
import ru.project.travel.entity.Tour;

import java.util.List;

@Component
public class TourMapper {


    public Tour toEntity(TourDto dto) {
        return new Tour
                (
                        dto.getId(),
                        dto.getCity(),
                        dto.getCountry(),
                        dto.getTitle(),
                        dto.getDescription(),
                        dto.getAmountTotalUser(),
                        dto.getStartDate(),
                        dto.getFinishDate(),
                        dto.getRank(),
                        dto.getAmountUser(),
                        dto.getPrice()
                );
    }

    public TourDto toDto(Tour entity) {
        return new TourDto
                (
                        entity.getId(),
                        entity.getCity(),
                        entity.getCountry(),
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.getAmountTotalUser(),
                        entity.getStartDate(),
                        entity.getFinishDate(),
                        entity.getRank(),
                        entity.getAmountUser(),
                        entity.getPrice()
                );
    }

    public List<Tour> toEntity(List<TourDto> dto) {
        return dto.stream().map(this::toEntity).toList();
    }

    public List<TourDto> toDto(List<Tour> entity) {
        return entity.stream().map(this::toDto).toList();
    }

    public Tour update(Tour entity, TourDto dto) {
        Tour entityUpdate = toEntity(dto);

        if (entityUpdate.getTitle() != null && !entityUpdate.getTitle().isEmpty()) {
            entity.setTitle(entityUpdate.getTitle());
        }
        if (entityUpdate.getDescription() != null && !entityUpdate.getDescription().isEmpty()) {
            entity.setDescription(entityUpdate.getDescription());
        }
        if (entityUpdate.getAmountTotalUser() != null && !entityUpdate.getAmountTotalUser().toString().isEmpty()) {
            entity.setAmountTotalUser(entityUpdate.getAmountTotalUser());
        }
        if (entityUpdate.getStartDate() != null && !entityUpdate.getStartDate().toString().isEmpty()) {
            entity.setStartDate(entityUpdate.getStartDate());
        }
        if (entityUpdate.getFinishDate() != null && !entityUpdate.getFinishDate().toString().isEmpty()) {
            entity.setFinishDate(entityUpdate.getFinishDate());
        }
        if (entityUpdate.getRank() != null && !entityUpdate.getRank().toString().isEmpty()) {
            entity.setRank(entityUpdate.getRank());
        }
        if (entityUpdate.getAmountUser() != null && !entityUpdate.getAmountUser().toString().isEmpty()) {
            entity.setAmountUser(entityUpdate.getAmountUser());
        }
        if (entityUpdate.getPrice() != null && !entityUpdate.getPrice().toString().isEmpty()) {
            entity.setPrice(entityUpdate.getPrice());
        }
        return entity;

    }


}
