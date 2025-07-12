package com.clinicavet.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "pets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {
    @Id
    private String id;

    private String name;
    private String species;
    private String breed;
    private LocalDate birthDate;
    private String ownerName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
