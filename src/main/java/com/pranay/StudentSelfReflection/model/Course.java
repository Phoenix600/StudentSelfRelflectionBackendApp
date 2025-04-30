package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	
	@ManyToMany
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(
					name = "course_id",
					referencedColumnName = "courseId"
			),
			inverseJoinColumns = @JoinColumn(
					name = "student_id",
					referencedColumnName = "studentId"
			)
	)
	private Set<StudentUser> studentUsers;
	
	@OneToMany(mappedBy = "course")
	private Set<Topic> topics;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
	private Teacher teacher;
}
