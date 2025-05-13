package com.pranay.StudentSelfReflection.services;

import com.pranay.StudentSelfReflection.model.Course;
import com.pranay.StudentSelfReflection.model.Topic;
import com.pranay.StudentSelfReflection.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

/**
 * File Name: CourseServices.java
 * Entity: CourseServices
 * Package: com.pranay.StudentSelfReflection.services
 * Author: pranayramteke
 * Date: 09/05/25
 * Description:
 */

@Service
public class CourseService
{
	@Autowired
	CourseRepository courseRepository;
	
	public Course saveCourse(Course course)
	{
		// TimeStamp Before The Actual Operation  (@Before)
		Instant startTime = Instant.now();
		System.out.println("saveCourse() method started at : " + startTime);

		Set<Topic> topics =  course.getTopics();
		for(Topic x: topics)
		{
			x.setCourse(course);
		}

		// Actual Operation (@Around)
		Course savedCourse =  courseRepository.save(course);

		// TimeStamp After The Actual Operation (@After)
		Instant endTime = Instant.now(); // 35 ms
		System.out.println("saveCourse() method finished at : " + endTime);
		System.out.println("saveCourse() method time elapsed : " + Duration.between(startTime, endTime));
		
		return savedCourse;
		
	}
}
