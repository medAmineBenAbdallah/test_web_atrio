package com.webatrio.personmanager.controller;

import com.webatrio.personmanager.dto.CreateJobDto;
import com.webatrio.personmanager.dto.CreatePersonDto;
import com.webatrio.personmanager.dto.FindJobsByDateRangDto;
import com.webatrio.personmanager.dto.JobDto;
import com.webatrio.personmanager.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static com.webatrio.personmanager.controller.JobController.JOB_MAPPING;


@RestController
@RequestMapping(JOB_MAPPING)
public class JobController {

    public static final String JOB_MAPPING = "/job";

    private JobService jobService;

    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createJob(@RequestBody @Validated CreateJobDto createJobDto){
        jobService.createJob(createJobDto);
    }


    @GetMapping("/job-range")
    public List<JobDto> getPersons(@RequestBody @Validated FindJobsByDateRangDto findJobsByDateRangDto) {

        return this.jobService.getPersonJobByDateRange(findJobsByDateRangDto);
    }

}