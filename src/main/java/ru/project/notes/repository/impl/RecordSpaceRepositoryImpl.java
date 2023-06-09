package ru.project.notes.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecordSpaceRepositoryImpl {
    @Autowired
    private JdbcTemplate template;


    public void deleteObjectById(Long id) {
        template.update("DELETE FROM tags WHERE record_id= ?", id);
        template.update("DELETE FROM space_record WHERE record_id= ?", id);
        template.update("DELETE FROM record_record WHERE record_one_id = ?", id);
        template.update("DELETE FROM record WHERE id= ?", id);
    }
}
