/*
    jobRepositoryTest.java
    Repository test for job
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.employee.Job;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class jobRepositoryTest {

    private final Job job1 = new Job.Builder()
            .setJobId("001")
            .setJobName("Waiter")
            .setJobDescription("Take orders and deliver meals")
            .build();

    @Autowired private JobRepository repository;

    @Test
    void save() {
        Job saved = repository.save(job1);
        assertNotNull(saved);
        assertSame(saved, job1);
    }

    @Test
    void read() {
        Job saved = repository.save(job1);
        Optional<Job> read = repository.findById(saved.getJobId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(job1, output)
        );
    }

    @Test
    void delete() {
        Job saved = repository.save(job1);
        List<Job> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(job1);
        List<Job> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }
}