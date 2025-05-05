package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>
{

}
