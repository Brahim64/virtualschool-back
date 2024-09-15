package com.VirtualSchool.vschool.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseFile {
    private Long id;
    private String name;
    private String url;
    private String type;
    private long size;
    private Long courseId;
}
