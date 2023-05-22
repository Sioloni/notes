package ru.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.travel.entity.Tour;

public interface TourRepository extends JpaRepository<Tour, Long> {


}
