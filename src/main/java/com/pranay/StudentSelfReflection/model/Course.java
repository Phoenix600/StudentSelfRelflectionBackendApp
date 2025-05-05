package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * File Name: Course.java
 * Entity: Course
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
public class Course extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String courseName;
	private String description;
	private Integer durationInMonths;
	
	// One Course Can Have Many Topics
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<Topic> topics = new HashSet<>();
	
	// Many Students Can Belong To Mny Courses
	@ManyToMany(mappedBy = "courses",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private Set<StudentUser> studentUsers = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private Set<Teacher> teachers = new HashSet<>();

}
