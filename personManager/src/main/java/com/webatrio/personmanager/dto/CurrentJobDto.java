package com.webatrio.personmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CurrentJobDto{
    private Long id;
    private String company;
    private String position;
    private LocalDate startDate;

}
