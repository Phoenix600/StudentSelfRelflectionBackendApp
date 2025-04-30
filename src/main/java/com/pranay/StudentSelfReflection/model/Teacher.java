package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * File Name: Teacher.java
 * Entity: Teacher
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Teacher extends Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobile;
	private LocalDate dob;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER , cascade = CascadeType.PERSIST )
	Set<Course> courses;
}
