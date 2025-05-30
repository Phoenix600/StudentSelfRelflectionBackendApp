package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//#TODO: Tell Uzma To Use Always @Repository Annotation
@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>
{

}
