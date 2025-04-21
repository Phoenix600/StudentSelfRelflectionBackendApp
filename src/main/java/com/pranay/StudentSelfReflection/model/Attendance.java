package com.pranay.StudentSelfReflection.model;

import com.pranay.StudentSelfReflection.constants.AttendanceStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

/**
 * File Name: Attendance.java
 * Entity: Attendance
 * Package: com.pranay.StudentSelfReflection.model
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

public class Attendance extends BaseEntity
{
	private LocalDate date;
	
	@Enumerated(EnumType.STRING)
	private String status;
	
}
