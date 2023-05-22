package ru.project.travel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
public class BasketDto {
    private Long id;

    @Positive
    private Long userId;

    private List<Long> tourId;

    @Positive
    private Double totalPrice;
}
