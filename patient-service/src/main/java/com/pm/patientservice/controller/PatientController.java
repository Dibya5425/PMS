package com.pm.patientservice.controller;


import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import com.pm.patientservice.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@Tag(name = "Patient", description = "Operations related to patient management")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;


    @GetMapping("/v1/all-patients")
    @Operation(summary = "Get all patients", description = "Retrieve a list of all registered patients")
    public ResponseEntity <List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping("/v1/create-patient")
    @Operation(summary = "Create a new patient", description = "Register a new patient with the provided details")
    public ResponseEntity <PatientResponseDTO> createPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO savedPatient = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(savedPatient);
    }

    @PutMapping("/v1/update-patient/{id}")
    @Operation(summary = "Update an existing patient", description = "Update the details of an existing patient by ID")
    public ResponseEntity <PatientResponseDTO> updatePatient(
            @PathVariable UUID id,
            @Validated({Default.class})
            @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO updatedPatient = patientService.updatePatirent(id, patientRequestDTO);
        return ResponseEntity.ok().body(updatedPatient);
    }

    @DeleteMapping("/v1/delete-patient/{id}")
    @Operation(summary = "Delete a patient", description = "Remove a patient from the system by ID")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
