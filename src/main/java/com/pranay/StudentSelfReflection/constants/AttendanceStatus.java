package com.pranay.StudentSelfReflection.constants;

/**
 * File Name: AttendanceStatus.java
 * Entity: AttendanceStatus
 * Package: com.pranay.StudentSelfReflection.constants
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

public enum AttendanceStatus
{
	ABSENT("ABSENT"),
	PRESENT("PRESENT"),
	LEAVE("LEAVE");
	
	private String status;
	private AttendanceStatus(String status)
	{
		this.status = status;
	}
	
	public String getStatus()
	{
		return this.status;
	}
	
}
