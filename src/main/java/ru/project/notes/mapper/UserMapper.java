package ru.project.notes.mapper;


import org.springframework.stereotype.Component;

import ru.project.notes.model.dto.UserDto;
import ru.project.notes.model.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public User toEntity(UserDto dto){
        return new User
                (
                        dto.getId(),
                        dto.getEmail(),
                        dto.getUsername(),
                        dto.getPassword(),
                        dto.getRole(),
                        dto.getStatus()
        );
    }

    public UserDto toDto(User entity){
        return new UserDto
                (
                        entity.getId(),
                        entity.getEmail(),
                        entity.getUsername(),
                        entity.getPassword(),
                        entity.getRole(),
                        entity.getStatus()
        );
    }

    public List<UserDto> toDto(List<User> entity){
        return entity.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> toEntity(List<UserDto> dto){
        return dto.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public User update(User entity, UserDto dto){
        User updateEntity = toEntity(dto);
        if(updateEntity.getEmail() != null && !updateEntity.getEmail().isEmpty()){
            entity.setEmail(updateEntity.getEmail());
        }
        if(updateEntity.getUsername() != null && !updateEntity.getUsername().isEmpty()){
            entity.setUsername(updateEntity.getUsername());
        }
        if(updateEntity.getPassword() != null && !updateEntity.getPassword().isEmpty()){
            entity.setPassword(updateEntity.getPassword());
        }
        if(updateEntity.getRole() != null && !updateEntity.getRole().name().isEmpty()){
            entity.setRole(updateEntity.getRole());
        }
        if(updateEntity.getStatus() != null && !updateEntity.getStatus().name().isEmpty()){
            entity.setStatus(updateEntity.getStatus());
        }
        return entity;
    }
}










