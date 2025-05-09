package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * File Name: CourseProgress.java
 * Entity: CourseProgress
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
public class CourseProgress extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseProgressId;
	
	private String remarks;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "student_id", referencedColumnName = "studentId")
	private StudentUser studentUser;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST,optional = true)
	@JoinColumn(name =  "course_id", referencedColumnName = "courseId")
	private Course course;
	
}
