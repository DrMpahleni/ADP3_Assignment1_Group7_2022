package za.ac.cput.repository.job;

import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Job;
import za.ac.cput.repository.job.impl.IJobRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class jobRepository implements IJobRepository {

    private static jobRepository repository = null;
    private Set<Job> jobDB = null;

    private jobRepository() {
        jobDB = new HashSet<Job>();
    }

    public static jobRepository getRepository() {
        if(repository == null) {
            repository = new jobRepository();
        }
        return repository;
    }

    @Override
    public Job create (Job job) {
        boolean success = jobDB.add(job);
        if (!success)
            return null;
        return job;
    }

    @Override
    public Job read (Integer jobId) {
        Job job = jobDB.stream()
                .filter(e -> e.getJobId() == jobId)
                .findAny()
                .orElse(null);
        return job;
    }

    @Override
    public Job update (Job job) {
        Job oldJob = read(job.getJobId());
        if(oldJob != null) {
            jobDB.remove(oldJob);
            jobDB.add(job);
            return job;
        }
        return null;
    }

    @Override
    public boolean delete (Integer jobId) {
        Job jobToDelete = read(jobId);
        if(jobToDelete == null)
            return false;
        jobDB.remove(jobToDelete);
        return true;
    }

    public Set<Job> getAll(){
        return jobDB;
    }
}
