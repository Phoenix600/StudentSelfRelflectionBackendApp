package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentUser,Long>
{

}
