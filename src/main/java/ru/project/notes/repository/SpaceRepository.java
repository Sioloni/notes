package ru.project.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.notes.model.entity.Space;

import java.util.List;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {




}
