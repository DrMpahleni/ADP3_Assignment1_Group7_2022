/*
    jobRepositoryTest.java
    Repository test for job
    Name: Ian Louw
    Student number: 216250773
 */

package za.ac.cput.repository.job;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Job;
import za.ac.cput.factory.JobFactory;

import static org.junit.jupiter.api.Assertions.*;

class jobRepositoryTest {

    private static jobRepository repository = jobRepository.getRepository();
    private static Job job = JobFactory.createJob( "Waiter", "Receives orders and delivers meals.");

    @Test
    void create() {
        Job created = repository.create(job);
        assertEquals(job.getJobId(),created.getJobId());
        System.out.println("Create: " + created);
    }

    @Test
    void read() {
        Job read = repository.read(job.getJobId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        Job updated = new Job.Builder().copy(job).setJobName("Waitress").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    void delete() {
        boolean deleted = repository.delete(job.getJobId());
        assertNotNull(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}