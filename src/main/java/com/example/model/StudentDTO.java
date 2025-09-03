package com.example.model;

import com.example.config.ValidPhone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long studentId;
    @Size(min = 4, max = 20, message = "firstName should be 3 to 20 charcater length")
    @NotEmpty
    private String firstName;
    @Size(min = 4, max = 20, message = "lastName should be 3 to 20 charcater length")
    @NotEmpty
    private String lastName;
    @ValidPhone  //Custom annotation
    private String phone;
    @Pattern(regexp = "^(?!.*\\.\\.)[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    // this pattenr is for password @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")
    private String email;
    @NotNull
    @NotEmpty
    private String city;
    @NotEmpty
    private String course;
}
