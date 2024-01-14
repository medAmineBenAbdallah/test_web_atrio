package com.webatrio.personmanager.service;

import com.webatrio.personmanager.dto.CreateJobDto;
import com.webatrio.personmanager.dto.FindJobsByDateRangDto;
import com.webatrio.personmanager.dto.JobDto;
import com.webatrio.personmanager.exception.PersonNotFoundException;
import com.webatrio.personmanager.model.Job;
import com.webatrio.personmanager.model.Person;
import com.webatrio.personmanager.repository.JobRepository;
import com.webatrio.personmanager.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;

    private PersonRepository personRepository;

    public JobService(JobRepository jobRepository, PersonRepository personRepository){
        this.jobRepository = jobRepository;
        this.personRepository = personRepository;

    }

    public void createJob(CreateJobDto createJobDto) {
        Optional<Person> person = personRepository.findById(createJobDto.personId());
        if (!person.isPresent()) {
            throw new PersonNotFoundException(createJobDto.personId());
        }
        Job job = Job.builder().person(person.get()).company(createJobDto.company()).startDate(createJobDto.startDate()).endDate(createJobDto.endDate()).position(createJobDto.position()).build();
        jobRepository.save(job);
    }

    public List<JobDto> getPersonJobByDateRange(FindJobsByDateRangDto findJobsByDateRangDto) {
        Optional<Person> person = personRepository.findById(findJobsByDateRangDto.personId());
        if (!person.isPresent()) {
            throw new PersonNotFoundException(findJobsByDateRangDto.personId());
        }
        List<Job> jobs = jobRepository.findByDateRange(findJobsByDateRangDto.startDate()
                , findJobsByDateRangDto.endDate(), findJobsByDateRangDto.personId());

        return jobs.stream().map(job -> JobDto.builder().id(job.getId()).startDate(job.getStartDate())
                .endDate(job.getEndDate()).company(job.getCompany()).position(job.getPosition()).build()).toList();
    }
}
