package com.example.model;

import com.example.entity.Address;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class TeacherDTO {
    private Long teacherId;
    private String firstName;
    private String lastName;
    @Size(min = 6)
    private String mobile;
    private Address address;
}
