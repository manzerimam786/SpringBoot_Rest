package com.example.model;

import com.example.entity.Address;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class TeacherDTO {
    @NotBlank
    private Integer teacherId;
    private String firstName;
    private String lastName;
    @Size(min = 6)
    private String mobile;
    @NotBlank
    private Address address;
}
