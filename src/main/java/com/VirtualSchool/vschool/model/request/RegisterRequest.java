package com.VirtualSchool.vschool.model.request;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
}
