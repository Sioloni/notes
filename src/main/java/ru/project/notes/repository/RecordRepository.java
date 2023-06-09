package ru.project.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.notes.model.entity.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {


}
