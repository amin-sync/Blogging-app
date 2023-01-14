package com.example.blogapplication.payloads;

import com.example.blogapplication.models.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class UserDto {
    private int id;
    @NotEmpty // we don't want name to be null that's why we use this annotation
    @Size(min = 4, message = "User name must be min 4 character")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min of 3 chars and max of 10 chars")
    private String password;
    @NotEmpty
    private String about;
    private List<RoleDto> roles = new ArrayList<>();
}
