package com.pranay.StudentSelfReflection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "teacher_course",
			joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId"),
			inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
	)
	private Set<Course> courses = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private Set<Batch> batches = new HashSet<>();
}
