/*
    jobRepositoryTest.java
    Repository test for job
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.job;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.factory.employee.JobFactory;
import za.ac.cput.repository.employee.JobRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class jobRepositoryTest {

    private final Job job1 = new Job.Builder()
            .setJobId("001")
            .setJobName("Waiter")
            .setJobDescription("Receive and deliver meals.")
            .build();

    private static JobRepository repository;
    private static Job job = JobFactory.createJob( "Waiter", "Receives orders and delivers meals.");

    @Test
    void create() {
        Job saved = repository.save(job1);
        String output = String.valueOf(saved);
        assertNotNull(saved);
        assertSame(saved, output);
    }

    @Test
    void read() {
        Job saved = repository.save(job1);
        Optional<Job> read = repository.findById(saved.getJobId());
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, output)
        );
    }

    @Test
    void update() {
        Job updated = new Job.Builder().copy(job1).setJobName("Waitress").build();
        assertNotNull(repository.save(updated));
        System.out.println("Update: " + updated);
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