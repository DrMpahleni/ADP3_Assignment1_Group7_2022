package za.ac.cput.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.repository.employee.JobRepository;
import za.ac.cput.service.employee.JobService;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository repository;

    public JobServiceImpl(JobRepository repository) {
        this.repository = repository;
    }

    public JobServiceImpl() {}

    public Job save (Job job) {
        return repository.save(job);
    }

    public Optional<Job> read (String jobId){
        return repository.findById(jobId);
    }

    public void delete (Job job) {
        repository.delete(job);
    }

    @Override
    public List<Job> getAll(String jobId) {
        return repository.findAll();
    }

    public void deleteById(String jobId) {
        Optional<Job> job = read(jobId);
        if (job.isPresent())delete(job.get());
    }
}
