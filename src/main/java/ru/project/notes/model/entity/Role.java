package ru.project.notes.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public enum Role {
    USER(Set.of(Permission.USER_READ)),
    ADMIN(Set.of(Permission.USER_READ, Permission.USER_WRITE));


    private Set<Permission> permission;


}
