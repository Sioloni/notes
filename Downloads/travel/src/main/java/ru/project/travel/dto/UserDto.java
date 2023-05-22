package ru.project.travel.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import ru.project.travel.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank
    @Size(min = 10)
    private String fio;

    @NotBlank
    @Size(min = 10)
    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String password;

    private Role role;
}
