package com.id.simian.userservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    @NotBlank(message = "FirstName Cannot Required")
    @NotNull(message = "FirstName Cannot Null")
    private String firstName;
    @NotBlank(message = "LastName Cannot Required")
    @NotNull(message = "LastName Cannot Null")
    private String lastName;
    @NotBlank(message = "Email Cannot Required")
    @NotNull(message = "Email Cannot Null")
    @Email(message = "Email Cannot Valid")
    private String email;
    @NotBlank(message = "Password Cannot Required")
    @NotNull(message = "Password Cannot Null")
    private String password;
    @NotNull(message = "Role Cannot Selected")
    private long role;

}
