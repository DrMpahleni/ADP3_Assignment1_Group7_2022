/*
    JobFactoryTest.java
    factory test for Job
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.factory.employee.JobFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class JobFactoryTest {

    private Job job1;
    private Job job2;

    @BeforeEach
    void setUp() {
        Job job1 = new Job.Builder().setJobName("Receptionist").build();
        Job job2 = job1;
    }

    @Test
    public void test () {

        Job job = JobFactory.createJob("Waiter", "Takes orders and delivers food");
        System.out.println(job.toString());
        assertNotNull(job);
    }

    @Test
    public void testEquality () {
        assertEquals(job1, job2);
        System.out.println("Both jobs are equal");
    }

    @Test
    public void testIdentity(){

        assertSame(job1, job2);
        System.out.println("Both jobs are identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(job1, job2);
    }

}