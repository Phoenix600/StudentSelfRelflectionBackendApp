package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * File Name: Batch.java
 * Entity: Batch
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 08/05/25
 * Description:
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Batch extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batchId;
	private String batchName;
	private LocalDate batchStartTime;
	private LocalDate batchEndTime;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<StudentUser> studentUsers = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "batch_teacher",
			joinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "batchId"),
			inverseJoinColumns = @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
	)
	private Set<Teacher> teachers = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			joinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "batchId"),
			inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	)
	private Set<Course> courses = new HashSet<>();
	
}
