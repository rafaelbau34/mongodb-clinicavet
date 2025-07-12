package com.clinicavet.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class PetResponse {
    private String id;
    private String name;
    private String species;
    private String breed;
    private LocalDate birthDate;
    private String ownerName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
