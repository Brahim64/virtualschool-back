package com.VirtualSchool.vschool.repository;

import com.VirtualSchool.vschool.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    void deleteCourseById(Long id);
    public List<Course> findAllByTeacher(String teacher);

    @Modifying
    @Query(value = "DELETE FROM courses WHERE code = ?", nativeQuery = true)
    void deletingByCode(String code);

}
