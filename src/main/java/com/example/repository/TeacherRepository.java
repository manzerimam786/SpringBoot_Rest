package com.example.repository;

import com.example.entity.Teacher;
import com.example.model.TeacherDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "select * from Teacher t join Address a on t.teacher_id = a.address_id where t.teacher_id=:teacherId", nativeQuery = true)
    Teacher findByTeacherId(Integer teacherId);
}
