/*
    JobFactory.java
    factory for Job
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Job;
import za.ac.cput.util.genericHelper;

public class JobFactory {

    public static Job createJob(int jobId, String jobName, String jobDescription) {

        String jobID = genericHelper.generateId();
        Job job = new Job.Builder().setJobId(jobID).
                                    setJobName(jobName).
                                    setJobDescription(jobDescription).
                                    build();

                                    return job;
    }
}
