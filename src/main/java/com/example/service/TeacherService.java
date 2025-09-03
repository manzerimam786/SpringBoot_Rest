package com.example.service;

import com.example.entity.Teacher;
import com.example.model.TeacherDTO;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacherById(Long teacherId) {
        System.out.println("inside teacherService");
        return teacherRepository.findByTeacherId(teacherId);
    }

    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacherEntity  = mapTeacherDTOToTeacherEntity(teacherDTO);
        return teacherRepository.save(teacherEntity);
    }

    private Teacher mapTeacherDTOToTeacherEntity(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setAddress(teacherDTO.getAddress());
        teacher.setMobile(teacherDTO.getMobile());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        //teacher.setTeacherId(teacherDTO.getTeacherId());
        return teacher;
    }
}
