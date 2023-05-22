package ru.project.travel.mapper;


import org.springframework.stereotype.Component;
import ru.project.travel.dto.UserDto;
import ru.project.travel.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public User toEntity(UserDto dto) {
        return new User
                (
                        dto.getId(),
                        dto.getFio(),
                        dto.getEmail(),
                        dto.getPassword(),
                        dto.getRole()
                );
    }

    public UserDto toDto(User entity) {
        return new UserDto
                (
                        entity.getId(),
                        entity.getFio(),
                        entity.getEmail(),
                        entity.getPassword(),
                        entity.getRole()
                );
    }

    public List<User> toEntity(List<UserDto> dto) {
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public List<UserDto> toDto(List<User> entity) {
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }


    public User update(User entity, UserDto dto) {
        User entityUpdate = toEntity(dto);
        if (entityUpdate.getFio() != null && !entityUpdate.getFio().isEmpty()) {
            entity.setFio(entityUpdate.getFio());
        }
        if (entityUpdate.getEmail() != null && !entityUpdate.getEmail().isEmpty()) {
            entity.setEmail(entityUpdate.getEmail());
        }
        if (entityUpdate.getEmail() != null && !entityUpdate.getEmail().isEmpty()) {
            entity.setEmail(entityUpdate.getEmail());
        }
        if (entityUpdate.getPassword() != null && !entityUpdate.getPassword().isEmpty()) {
            entity.setPassword(entityUpdate.getPassword());
        }
        if (entityUpdate.getRole() != null && !entityUpdate.getRole().name().isEmpty()) {
            entity.setRole(entityUpdate.getRole());
        }
        return entity;
    }

}
