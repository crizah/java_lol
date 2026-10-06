package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // this is there so i dont have to map the json into the objects directly
public class SignUpRequest {
    @NotBlank @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "invalid phone number")
    private String phoneNumber;

    @NotBlank
    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;
}
