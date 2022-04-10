package za.ac.cput.repository.job.impl;

import za.ac.cput.entity.Job;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IJobRepository extends IRepository <Job, String> {

    public Set<Job> getAll();
}
