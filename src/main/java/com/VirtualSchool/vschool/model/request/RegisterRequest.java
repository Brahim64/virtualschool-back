package com.VirtualSchool.vschool.model.request;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
}
