package com.VirtualSchool.vschool.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.SecureRandom;

@Entity
@Table(name = "courses")
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String title;
    private String teacher;



    public static String generateRandomCode() {
        int length = 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            code.append(characters.charAt(index));
        }
        return code.toString();
    }


    @Override
    public String toString() {
        return
                "{\"id\": " + id +
                ",\"code\": " +"\""+ code +"\""+
                ",\"title\": " +"\""+ title +"\""+
                ",\"teacher\": " +"\""+ teacher +"\"}" ;
    }
}
