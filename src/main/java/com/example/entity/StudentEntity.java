package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer studentId;
    @Column
    String firstName;
    @Column
    String lastName;
    @Column
    String city;
    @Column
    String phone;
    @Column
    String email;
    @Column
    String course;
}
