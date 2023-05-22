package ru.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.travel.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
