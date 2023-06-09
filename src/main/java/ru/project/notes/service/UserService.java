package ru.project.notes.service;


import ru.project.notes.model.dto.UserDto;
import ru.project.notes.model.entity.User;

import java.util.List;

public interface UserService {
    User getEntity(Long id);

    List<UserDto> get();

    UserDto get(Long id);

    void create(UserDto dto);

    void update(Long id, UserDto dto);

    void delete(Long id);

}
