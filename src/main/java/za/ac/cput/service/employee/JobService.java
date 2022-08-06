package za.ac.cput.service.employee;

import za.ac.cput.domain.employee.Job;
import za.ac.cput.service.IService;

import java.util.List;

public interface JobService extends IService<Job, String> {

    List<Job> getAll(String jobId);
    void deleteById(String jobId);
}
