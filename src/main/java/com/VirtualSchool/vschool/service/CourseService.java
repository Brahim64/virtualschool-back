package com.VirtualSchool.vschool.service;

import com.VirtualSchool.vschool.model.Course;
import com.VirtualSchool.vschool.model.request.CourseRequest;
import com.VirtualSchool.vschool.repository.CourseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public void save(CourseRequest courseRequest) {
        Course course = Course.builder()
                .code(courseRequest.getCode())
                .title(courseRequest.getTitle())
                .teacher(courseRequest.getTeacher())
                .build();
        courseRepository.save(course);
    }

    public String findByTeacher(String teacher) {
        List<Course> courses= courseRepository.findAllByTeacher(teacher);
        return courses.toString();
    }
    @Transactional
    public void delete(String code) {
        courseRepository.deletingByCode(code);
    }
}
