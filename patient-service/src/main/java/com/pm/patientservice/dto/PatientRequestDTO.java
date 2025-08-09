package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotNull(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Address is required")
    private String address;

    @NotNull(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotNull(message = "Registration Date is required")
    private String registrationDate;

    // Getters and Setters
    public @NotNull(message = "Name is required") @Size(max = 100, message = "Name cannot exceed 100 characters") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name is required") @Size(max = 100, message = "Name cannot exceed 100 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotNull(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotNull(message = "Address is required") String address) {
        this.address = address;
    }

    public @NotNull(message = "Date of Birth is required") String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull(message = "Date of Birth is required") String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull(message = "Registration Date is required") String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@NotNull(message = "Registration Date is required") String registrationDate) {
        this.registrationDate = registrationDate;
    }



}
