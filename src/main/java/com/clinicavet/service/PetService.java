package com.clinicavet.service;

import com.clinicavet.dto.PetRequest;
import com.clinicavet.dto.PetResponse;
import com.clinicavet.exception.PetNotFoundException;
import com.clinicavet.model.Pet;
import com.clinicavet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository repository;

    public PetResponse create(PetRequest request) {
        Pet pet = Pet.builder()
                .name(request.getName())
                .species(request.getSpecies())
                .breed(request.getBreed())
                .birthDate(request.getBirthDate())
                .ownerName(request.getOwnerName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return toResponse(repository.save(pet));
    }

    public List<PetResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public PetResponse findById(String id) {
        Pet pet = repository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        return toResponse(pet);
    }

    public PetResponse update(String id, PetRequest request) {
        Pet pet = repository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));

        pet.setName(request.getName());
        pet.setSpecies(request.getSpecies());
        pet.setBreed(request.getBreed());
        pet.setBirthDate(request.getBirthDate());
        pet.setOwnerName(request.getOwnerName());
        pet.setUpdatedAt(LocalDateTime.now());

        return toResponse(repository.save(pet));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    private PetResponse toResponse(Pet pet) {
        return PetResponse.builder()
                .id(pet.getId())
                .name(pet.getName())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .birthDate(pet.getBirthDate())
                .ownerName(pet.getOwnerName())
                .createdAt(pet.getCreatedAt())
                .updatedAt(pet.getUpdatedAt())
                .build();
    }
}
