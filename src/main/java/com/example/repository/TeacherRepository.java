package com.example.repository;

import com.example.entity.Teacher;
import com.example.model.TeacherDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    //@Query(value = "select * from Teacher t join Address a on t.address_id = a.address_id where t.teacher_id = :teacherId", nativeQuery = true)
   // @Query(value = "select * from Teacher t join Address a on t.teacher_id = a.address_id where t.teacher_id=:teacherId", nativeQuery = true)
   // @Query("select t from Teacher t join fetch t.address where t.teacherId = :teacherId")
   // Teacher findByTeacherId(Integer teacherId);
    @Query("select t from Teacher t join fetch t.address where t.teacherId = :teacherId")
    Teacher findByTeacherId(@Param("teacherId") Long teacherId);

}
