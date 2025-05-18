package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    int studentId;
    @Size(min = 6, max = 20, message = "firstName should be 3 to 20 charcater length")
    @NotEmpty
    private String firstName;
    @Size(min = 5, max = 20, message = "lastName should be 3 to 20 charcater length")
    @NotEmpty
    private String lastName;
    private String phone;
    @Email
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String city;
    @NotEmpty
    private String course;
}
