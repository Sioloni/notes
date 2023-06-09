package ru.project.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.notes.mapper.UserMapper;
import ru.project.notes.model.dto.UserDto;
import ru.project.notes.model.entity.User;
import ru.project.notes.model.exception.ApplicationException;
import ru.project.notes.model.exception.ExceptionMessage;
import ru.project.notes.repository.UserRepository;
import ru.project.notes.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public User getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
    }

    @Override
    public List<UserDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMessage.ID_NOT_FOUND)));
    }

    @Override
    public void create(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, UserDto dto) {
        User entity = getEntity(id);
        repository.save(mapper.update(entity, dto));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
