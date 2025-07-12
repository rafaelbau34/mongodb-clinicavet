package com.clinicavet.controller;

import com.clinicavet.dto.PetRequest;
import com.clinicavet.dto.PetResponse;
import com.clinicavet.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @PostMapping
    public PetResponse create(@RequestBody @Valid PetRequest request) {
        return petService.create(request);
    }

    @GetMapping
    public List<PetResponse> getAll() {
        return petService.findAll();
    }

    @GetMapping("/{id}")
    public PetResponse getById(@PathVariable String id) {
        return petService.findById(id);
    }

    @PutMapping("/{id}")
    public PetResponse update(@PathVariable String id, @RequestBody @Valid PetRequest request) {
        return petService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        petService.delete(id);
    }
}
