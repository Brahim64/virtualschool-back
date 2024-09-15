package com.VirtualSchool.vschool.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long CourseId;
    private String name;
    private String type;

    @Lob
    private byte[] data;

    public FileDB(Long CourseId,String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.CourseId = CourseId;
    }
}
