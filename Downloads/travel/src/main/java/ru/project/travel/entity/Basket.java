package ru.project.travel.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "basket")
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "basket_tours", joinColumns = @JoinColumn(name = "basket_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "tour_id", nullable = false))
    private Set<Tour> tours;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
