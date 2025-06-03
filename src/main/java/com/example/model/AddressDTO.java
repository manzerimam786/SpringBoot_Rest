package com.example.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class AddressDTO {
    @NotBlank
    private Integer addressId;
    private String city;
    @Size(min = 10, max = 30)
    private String streetName;
    private String state;
    private String country;
    @Size(min = 4,max = 6)
    private Integer pinCode;
}
