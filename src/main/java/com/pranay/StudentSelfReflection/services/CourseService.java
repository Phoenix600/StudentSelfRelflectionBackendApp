package com.pranay.StudentSelfReflection.services;

import com.pranay.StudentSelfReflection.model.Course;
import com.pranay.StudentSelfReflection.model.Topic;
import com.pranay.StudentSelfReflection.repository.CourseRepository;
import com.pranay.StudentSelfReflection.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService
{
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TopicRepository topicRepository;
	
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




	public Course updateCourse(Long id,Course course)
	{
		// TimeStamp Before The Actual Operation  (@Before)
		Instant startTime = Instant.now();
		System.out.println("updateCourse() method started at : " + startTime);

		// Starts Here Code
		Course upadtedCourse = null;
		// Fetch The Course With courseId
		Optional<Course> courseOptional = courseRepository.findById(id);

		// Then Write The Code For Update
		if(courseOptional.isPresent())
		{
			Course fetchedCourse = courseOptional.get();

			if(!course.getCourseName().isEmpty())
			{
				String courseName = course.getCourseName();
				fetchedCourse.setCourseName(courseName);
			}

			if(!course.getDescription().isEmpty())
			{
				String courseDescription = course.getDescription();
				fetchedCourse.setDescription(courseDescription);
			}
			
			if(!(course.getDurationInMonths() >= 0))
			{
				Integer courseDurationInMonths = course.getDurationInMonths();
				fetchedCourse.setDurationInMonths(courseDurationInMonths);
			}
			
			
			upadtedCourse =  courseRepository.save(fetchedCourse);

		}
		// End Of Code

		// TimeStamp After The Actual Operation (@After)
		Instant endTime = Instant.now(); // 35 ms
		System.out.println("updateCourse() method finished at : " + endTime);
		System.out.println("updateCourse() method time elapsed : " + Duration.between(startTime, endTime));

		// send updated object
		return upadtedCourse;
	}



	public Course updateCourseTopicByTopicId(Long courseId, Long topicId, Topic topic)
	{
		// TimeStamp Before The Actual Operation  (@Before)
		Instant startTime = Instant.now();
		System.out.println("updateCourseTopicByTopicId() method started at : " + startTime);

		// Starts Here Code
		Course updatedTopicsCourse = null;
		// Fetch The Course With courseId
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if(courseOptional.isPresent())
		{
			updatedTopicsCourse = courseOptional.get();

			for(Topic target :  updatedTopicsCourse.getTopics())
			{
				if(target.getTopicId().equals(topicId))
				{
					if(topic.getTitle().isEmpty())
					{
						target.setTitle(topic.getTitle());
					}

					if(topic.getDescription().isEmpty())
					{
						target.setDescription(topic.getDescription());
					}

					break;
				}

			}
			updatedTopicsCourse =   courseRepository.save(updatedTopicsCourse);

		}

		// TimeStamp After The Actual Operation (@After)
		Instant endTime = Instant.now(); // 35 ms
		System.out.println("updateCourseTopicByTopicId() method finished at : " + endTime);
		System.out.println("updateCourseTopicByTopicId() method time elapsed : " + Duration.between(startTime, endTime));

		return updatedTopicsCourse;
	}
	
	public String deleteCourseByCourseId(Long courseId)
	{
		String status = "Unable To Locate Course";
		Optional<Course> courseOptional = courseRepository.findById(courseId);
		
		if(courseOptional.isPresent())
		{
			Course courseFromDb = courseOptional.get();
			Set<Topic> topics =  courseFromDb.getTopics();
			
			try{
				for(Topic topic : topics)
				{
					topic.setCourse(null);
					topicRepository.delete(topic);
				}
				
				courseRepository.delete(courseFromDb);
				
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			status = "Course Deleted Successfully";
			
		}
		
		return status;
	}
	
	public Course addTopicToExistingCourseWithCourseId(Long courseId, Topic topic)
	{
		Course fetchedCourseFromDB = courseRepository.findById(courseId).get();
		Set<Topic> topics = fetchedCourseFromDB.getTopics();
		topic.setCourse(fetchedCourseFromDB);
		topic =  topicRepository.save(topic);
		topics.add(topic);
		fetchedCourseFromDB =  courseRepository.save(fetchedCourseFromDB);
		return fetchedCourseFromDB;
	}
}
