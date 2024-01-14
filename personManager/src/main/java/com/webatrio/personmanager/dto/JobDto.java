package com.webatrio.personmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class JobDto {
    private Long id;
    private String company;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;

}
