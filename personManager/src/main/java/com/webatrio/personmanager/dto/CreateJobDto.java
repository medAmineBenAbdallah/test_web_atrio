package com.webatrio.personmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateJobDto(@NotNull LocalDate startDate, LocalDate endDate, @NotBlank String position,
                           @NotBlank String company, @NotNull long personId) {
}
