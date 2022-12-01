package com.bolsaideas.springboot.form.app.models.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String password;
    private String email;
}
