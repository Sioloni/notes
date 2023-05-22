package ru.project.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tour")
@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "amount_total_user", nullable = false)
    private Integer amountTotalUser;

    @Column(name = "start_date", nullable = false)

    private LocalDateTime startDate;

    @Column(name = "finish_date", nullable = false)
    private LocalDateTime finishDate;

    @Column(nullable = false)
    private Integer rank;

    @Column(name = "amount_user", nullable = false)
    private Integer amountUser;

    @Column(nullable = false)
    private Double price;


}
