package com.example.respository;

import com.example.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    //@Query(value = "select e from StudentEntity e where e.firstName =:name")   //  JPQL Query
    @Query(value = "select * from Student e where e.first_name =:name" , nativeQuery = true) // SQL Query
    List<StudentEntity> getLastName(@Param("name") String name); // if you won't use findBy...() or getBy...() then need to add @Query
    StudentEntity findByFirstNameAndLastName(String firstName, String lastName);

}
