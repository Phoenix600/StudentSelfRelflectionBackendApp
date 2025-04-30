package com.pranay.StudentSelfReflection.model;

import com.pranay.StudentSelfReflection.constants.AttendanceStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * File Name: Attendance.java
 * Entity: Attendance
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

@Entity
public class Attendance extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attendanceId;
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	private AttendanceStatus status;
	
	@ManyToOne
	@JoinColumn(name = "student_id", referencedColumnName = "studentId")
	private StudentUser studentUser;
}
