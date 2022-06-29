package com.lucasrb.batch.controller;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.criteria.params.CustomParams;
import com.lucasrb.batch.service.CustomerService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobLauncher jobLauncher;
    private final Job job;
    private final CustomerService service;

    public JobController(JobLauncher jobLauncher, Job job, CustomerService service) {
        this.jobLauncher = jobLauncher;
        this.job = job;
        this.service = service;
    }

    @PostMapping("/importCustomers")
    public void importCsvToDBJob() throws JobParametersInvalidException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> consultarCustomers(@RequestParam(name = "page") Integer page, @RequestParam(name = "pageSize") Integer pageSize){
        CustomParams params = new CustomParams();
        params.setPage(page);
        params.setPageSize(pageSize);

        List<Customer> customers = service.getCustomers(params);
        System.out.println(customers.size());
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

}
