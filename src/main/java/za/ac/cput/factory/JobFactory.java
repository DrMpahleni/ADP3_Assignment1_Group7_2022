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

    public static Job createJob(String jobName, String jobDescription) {

        if (genericHelper.isNullOrEmpty(jobName) || genericHelper.isNullOrEmpty(jobDescription))
            return null;

        int jobId = genericHelper.generateIntId();

        Job job = new Job.Builder().setJobId(jobId).
                                    setJobName(jobName).
                                    setJobDescription(jobDescription).
                                    build();

                                    return job;
    }
}
