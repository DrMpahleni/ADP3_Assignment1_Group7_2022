/*
    JobController.java
    Controller for Job
    Student: Ian Louw
    Student Number: 216250773
 */

package za.ac.cput.controller.employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.service.employee.JobService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/job/")
@Slf4j
public class JobController {

    private final JobService jobService;

    @Autowired public JobController (JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("save")
    public ResponseEntity<Job> save (@Valid @RequestBody Job job) {
        log.info("Save request: {}", job);
        Job save = jobService.create(job);
        return ResponseEntity.ok(save);
    }

    private Optional<Job> getById(String jobId){
        return this.jobService.read(jobId);
    }

    @GetMapping("read/{jobId}")
    public ResponseEntity<Job> read (@PathVariable String jobId) {
        log.info("Read request: {}", jobId);
        Job job = getById(jobId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(job);
    }

    @PutMapping("update")
    public ResponseEntity<Job> update (@Valid @RequestBody Job job) {
        log.info("Update request: {}", job);
        Job updated = jobService.update(job);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete (@PathVariable String jobId) {
        log.info("Read request: {}", jobId);
        this.jobService.deleteById(jobId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Job>> getAll (String jobId) {
        List<Job> jobs = this.jobService.getAll(jobId);
        return ResponseEntity.ok(jobs);
    }
}
