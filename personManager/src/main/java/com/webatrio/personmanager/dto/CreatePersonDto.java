package com.webatrio.personmanager.dto;


import lombok.NonNull;

import java.time.LocalDate;

public record CreatePersonDto(@NonNull String firstName, @NonNull String lastName, @NonNull LocalDate birthDate) {
}
