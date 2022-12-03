package com.bolsaideas.springboot.form.app.models.domain;

import com.bolsaideas.springboot.form.app.validation.IdentifiationRegexAnnotation;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    //@IdentifiationRegexAnnotation
    private String identify;

    @NotEmpty
    @Size(min = 3, max = 28)
    private String username;

    @NotEmpty(message = "password have not be empty")
    private String password;

    //@NotEmpty
    //@Email
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastName;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;
}
