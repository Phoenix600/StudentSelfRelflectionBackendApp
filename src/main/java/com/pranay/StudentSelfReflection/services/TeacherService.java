package com.pranay.StudentSelfReflection.services;

import com.pranay.StudentSelfReflection.model.Teacher;
import com.pranay.StudentSelfReflection.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        // TimeStamp Before The Actual Operation  (@Before)
        Instant startTime = Instant.now();
        System.out.println("saveTeacher() method started at : " + startTime);

        // Actual Operation (@Around)
        Teacher savedTeacher = teacherRepository.save(teacher);

        // TimeStamp After The Actual Operation (@After)
        Instant endTime = Instant.now();
        System.out.println("saveTeacher() method finished at : " + endTime);
        System.out.println("saveTeacher() method time elapsed : " + Duration.between(startTime, endTime));

        return savedTeacher;
    }




    public String deleteTeacherById(Long teacherId) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(teacherId);

        if (teacherOptional.isPresent()) {
            Teacher teacher = teacherOptional.get();

            // Optional: clear associations if needed, e.g. remove teacher from courses/batches
            teacher.getCourses().clear();
            teacher.getBatches().clear();

            teacherRepository.delete(teacher);
            return "Teacher deleted successfully";
        } else {
            return "Teacher not found";
        }
    }
    }
