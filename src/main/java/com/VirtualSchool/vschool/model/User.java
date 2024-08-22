package com.VirtualSchool.vschool.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank private String lastName;

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;

    @NotBlank
    private String role;

}
