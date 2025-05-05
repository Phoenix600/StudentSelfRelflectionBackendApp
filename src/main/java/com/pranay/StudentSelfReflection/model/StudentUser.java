package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentUser extends Users
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(unique = true)
	private String rollNumber;
	
	private LocalDate dateOfBirth;
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "studentUser")
	private Set<Attendance> attendances = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "studentuser_courses",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
			inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	)
	private Set<Course> courses = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,mappedBy = "studentUser")
	private Set<CourseProgress> courseProgresses = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST,mappedBy = "studentUser")
	private Set<FeePayment> feePayments = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
			inverseJoinColumns = @JoinColumn(name = "batch_id", referencedColumnName = "batchId")
	)
	private Set<Batch> batches = new HashSet<>();
	
	
	
}
