package com.VirtualSchool.vschool.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
