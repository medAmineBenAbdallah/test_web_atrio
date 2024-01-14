package com.webatrio.personmanager.controller;

import com.webatrio.personmanager.dto.CreatePersonDto;
import com.webatrio.personmanager.dto.PersonByCompanyDto;
import com.webatrio.personmanager.dto.PersonDto;
import com.webatrio.personmanager.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.webatrio.personmanager.controller.PersonController.PERSON_MAPPING;

@RestController
@RequestMapping(PERSON_MAPPING)
public class PersonController {

    public static final String PERSON_MAPPING = "/person";

    private PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody @Validated CreatePersonDto createPersonDto){
        personService.createPerson(createPersonDto);
    }

    @GetMapping("/all")
    public List<PersonDto> getPersons() {

        return this.personService.getPersonCurentPosition();
    }


    @GetMapping("/company-person")
    public List<PersonByCompanyDto> getPersones(@RequestParam String company) {

        return this.personService.getPersonByCompany(company);
    }



}
