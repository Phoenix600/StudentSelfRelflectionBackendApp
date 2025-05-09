package com.pranay.StudentSelfReflection.controller;

import com.pranay.StudentSelfReflection.model.Course;
import com.pranay.StudentSelfReflection.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * File Name: AdminController.java
 * Entity: AdminController
 * Package: com.pranay.StudentSelfReflection.controller
 * Author: pranayramteke
 * Date: 29/04/25
 * Description:
 */

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminController
{
	
	@Autowired
	CourseService courseService;
	
	// POST http://localhost:8080/api/v1/admin/create-course
	@PostMapping("/create-course")
	public ResponseEntity<Course> createCourse(@RequestBody Course course)
	{
		Course courseResponse = courseService.saveCourse(course);
		return new ResponseEntity<Course>(courseResponse, HttpStatus.CREATED);
	}
}
