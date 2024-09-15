package com.VirtualSchool.vschool.controller;

import com.VirtualSchool.vschool.model.Course;
import com.VirtualSchool.vschool.model.request.CourseRequest;
import com.VirtualSchool.vschool.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping(value = "/add")
    public ResponseEntity<String> AddCourse(@RequestBody CourseRequest courseRequest) {
        try {
            System.out.println("begin");
            courseService.save(courseRequest);
            System.out.println("saved");
            return ResponseEntity.ok("Course added successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping(value = "/all/{teacher}")
    public String getAllCourses(@PathVariable String teacher) {
        var courses=courseService.findByTeacher(teacher);
        System.out.println(courses);
        return courses;
    }
    @DeleteMapping(value = "/delete/{code}")
    public ResponseEntity<String> deleteCourses(@PathVariable String code) {
        try {
            courseService.delete(code);
            return ResponseEntity.ok().body("Course deleted successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
