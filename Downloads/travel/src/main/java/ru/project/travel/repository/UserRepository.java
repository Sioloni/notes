package ru.project.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.travel.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
