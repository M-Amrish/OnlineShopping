package dev.amrish.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private String name;
    private String email;
    private List<Role> roles;
}
