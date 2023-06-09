package ru.project.notes.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.project.notes.model.entity.Role;
import ru.project.notes.model.entity.Status;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @Email
    private String email;

    @NotBlank
    private String username;

    @Size(min = 5, max = 30)
    private String password;

    private Role role = Role.USER;

    private Status status = Status.ACTIVE;
}



