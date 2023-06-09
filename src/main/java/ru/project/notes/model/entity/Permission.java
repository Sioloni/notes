package ru.project.notes.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private String permission;
}


