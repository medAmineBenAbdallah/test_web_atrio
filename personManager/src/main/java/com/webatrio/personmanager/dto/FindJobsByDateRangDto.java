package com.webatrio.personmanager.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FindJobsByDateRangDto(@NotNull Long personId, @NotNull LocalDate startDate, @NotNull LocalDate endDate) {
}
