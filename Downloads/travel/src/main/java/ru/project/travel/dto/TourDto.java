package ru.project.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class TourDto {
    private Long id;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(value = 10)
    @Max(value = 45)
    private Integer amountTotalUser;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    @Min(value = 1)
    @Max(value = 5)
    private Integer rank;

    @Positive
    private Integer amountUser;

    @Positive
    private Double price;

}
