package com.pranay.StudentSelfReflection.repository;

import com.pranay.StudentSelfReflection.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long>
{

}
