/*
    JobFactory.java
    factory for Job
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Job;

public class JobFactory {

    public static Job createJob(int jobId, String jobName, String jobDescription) {

        Job job = new Job.Builder().setJobId(jobId).
                                    setJobName(jobName).
                                    setJobDescription(jobDescription).
                                    build();

                                    return job;
    }
}
