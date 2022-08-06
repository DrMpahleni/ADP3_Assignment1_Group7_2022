package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.repository.IRepository;

import java.util.Set;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    public Set<Job> getAll();
}
