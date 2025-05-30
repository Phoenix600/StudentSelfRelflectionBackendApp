package com.pranay.StudentSelfReflection.services;

import com.pranay.StudentSelfReflection.model.Batch;
import com.pranay.StudentSelfReflection.model.Teacher;
import com.pranay.StudentSelfReflection.repository.BatchRepository;
import com.pranay.StudentSelfReflection.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    // CREATE Batch (with or without associated teachers)
    public Batch saveBatch(Batch batch) {
        Instant startTime = Instant.now();
        System.out.println("saveBatch() started at: " + startTime);

        // Check and attach teachers (if any exist in the input)
        Set<Teacher> attachedTeachers = new HashSet<>();
        for (Teacher teacher : batch.getTeachers()) {
            Optional<Teacher> dbTeacher = teacherRepository.findById(teacher.getTeacherId());
            dbTeacher.ifPresent(attachedTeachers::add);
        }

        batch.setTeachers(attachedTeachers); // set only valid teachers

        Batch savedBatch = batchRepository.save(batch);

        Instant endTime = Instant.now();
        System.out.println("saveBatch() finished at: " + endTime);
        System.out.println("Elapsed time: " + Duration.between(startTime, endTime));

        return savedBatch;
    }

    public Batch updateBatch(Long batchId, Batch batch) {
        Instant startTime = Instant.now();
        System.out.println("updateBatch() started at: " + startTime);

        Batch updatedBatch = null;
        Optional<Batch> batchOptional = batchRepository.findById(batchId);

        if (batchOptional.isPresent()) {
            Batch fetchedBatch = batchOptional.get();

            if (batch.getBatchName() != null && !batch.getBatchName().isEmpty()) {
                fetchedBatch.setBatchName(batch.getBatchName());
            }

            if (batch.getBatchStartTime() != null) {
                fetchedBatch.setBatchStartTime(batch.getBatchStartTime());
            }

            if (batch.getBatchEndTime() != null) {
                fetchedBatch.setBatchEndTime(batch.getBatchEndTime());
            }

            // Update teachers if provided
            if (batch.getTeachers() != null) {
                Set<Teacher> validTeachers = new HashSet<>();
                for (Teacher teacher : batch.getTeachers()) {
                    teacherRepository.findById(teacher.getTeacherId())
                            .ifPresent(validTeachers::add);
                }
                fetchedBatch.setTeachers(validTeachers);
            }

            // Update courses if provided
            if (batch.getCourses() != null) {
                fetchedBatch.setCourses(batch.getCourses());
            }

            updatedBatch = batchRepository.save(fetchedBatch);
        }

        Instant endTime = Instant.now();
        System.out.println("updateBatch() finished at: " + endTime);
        System.out.println("updateBatch() time elapsed: " + Duration.between(startTime, endTime));

        return updatedBatch;
    }
}
