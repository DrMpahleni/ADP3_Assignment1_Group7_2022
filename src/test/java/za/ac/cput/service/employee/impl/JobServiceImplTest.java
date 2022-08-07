package za.ac.cput.service.employee.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.service.employee.JobService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceImplTest {

    private final Job job = new Job.Builder()
            .setJobId("0001")
            .setJobName("Waiter")
            .setJobDescription("Take customer orders and deliver food")
            .build();

    @Autowired
    private JobService service;

    @Test
    void save() {
        Job saved = service.save(job);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(job, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        Job saved = service.save(job);
        Optional<Job> read = service.read(saved.getJobId());
        System.out.println(read);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(job, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(job);
    }

    @Test
    void findByJobId() {
        Job saved = service.save(job);
        String jobId = saved.getJobId();
        List<Job> jobNameList = service.getAll(jobId);
        System.out.println(jobNameList);
        assertSame(1, jobNameList.size());
    }

}