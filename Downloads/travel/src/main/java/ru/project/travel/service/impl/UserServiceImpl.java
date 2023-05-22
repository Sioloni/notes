package ru.project.travel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.project.travel.dto.UserDto;
import ru.project.travel.exception.ApplicationException;
import ru.project.travel.exception.ExceptionMassage;
import ru.project.travel.mapper.UserMapper;
import ru.project.travel.repository.UserRepository;
import ru.project.travel.service.UserService;
import ru.project.travel.entity.User;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public User getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMassage.ID_NOT_FOUND));
    }

    @Override
    public List<UserDto> get() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new ApplicationException(ExceptionMassage.ID_NOT_FOUND)));
    }

    @Override
    public void create(UserDto dto) {
        repository.save(mapper.toEntity(dto));
    }

    @Override
    public void update(Long id, UserDto dto) {
        User user = mapper.update(mapper.toEntity(get(id)), dto);
        repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
