package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>
{

}
