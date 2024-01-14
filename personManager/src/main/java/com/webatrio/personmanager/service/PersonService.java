package com.webatrio.personmanager.service;

import com.webatrio.personmanager.dto.CreatePersonDto;
import com.webatrio.personmanager.dto.CurrentJobDto;
import com.webatrio.personmanager.dto.PersonByCompanyDto;
import com.webatrio.personmanager.dto.PersonDto;
import com.webatrio.personmanager.exception.PersonTooOldException;
import com.webatrio.personmanager.model.Job;
import com.webatrio.personmanager.model.Person;
import com.webatrio.personmanager.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class PersonService {

    private static final int MAX_AGE_OF_PERSON = 150;
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void createPerson(CreatePersonDto createPersonDto){
        if(LocalDate.now().minusYears(MAX_AGE_OF_PERSON).isAfter(createPersonDto.birthDate())){
            throw new PersonTooOldException();
        }
        Person person = Person.builder().firstName(createPersonDto.firstName())
                .lastName(createPersonDto.lastName())
                .birthDate(createPersonDto.birthDate())
                .build();
        personRepository.save(person);
    }

    public List<PersonDto>  getPersonCurentPosition(){
        List<Person> personList =  personRepository.findAllByOrderByFirstName();

        List<PersonDto> persoDtoList = personList.stream().map(person -> PersonDto.builder().id(person.getId()).age(getAge(person.getBirthDate()))
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .currentJobs(getCurrentJobs(person.getJobs()))
                .build()).toList();

        return persoDtoList;
    }

    private List<CurrentJobDto> getCurrentJobs(List<Job> jobs) {
        return jobs.stream().map(job -> CurrentJobDto.builder().id(job.getId()).company(job.getCompany()).position(job.getPosition()).build())
                .toList();
    }


    private int getAge(LocalDate birthdate){
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public List<PersonByCompanyDto> getPersonByCompany(String company) {
        List<Person> persons = personRepository.findAllByOrderByJobCompany(company);

        return persons
                .stream().map(person -> PersonByCompanyDto.builder().id(person.getId()).age(getAge(person.getBirthDate()))
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .build()).toList();
    }
}
