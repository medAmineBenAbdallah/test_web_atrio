package com.webatrio.personmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class PersonDto{
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private List<CurrentJobDto> currentJobs;
}
