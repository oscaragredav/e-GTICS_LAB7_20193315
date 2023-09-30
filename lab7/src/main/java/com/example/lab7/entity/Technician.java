package com.example.lab7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "technician")
public class Technician {
    @Id
    @Column(name = "TechnicianID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Pattern(regexp = "^[A-Za-zñáéíóúÁÉÍÓÚ ]+$", message = "El nombre debe contener solo letras")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 letras")
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstname;

    @Size(max = 100)
    @NotNull
    @Pattern(regexp = "^[A-Za-zñáéíóúÁÉÍÓÚ ]+$", message = "El apellido debe contener solo letras")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 letras")
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastname;

    @Size(max = 8)
    @NotNull
    @Size(min = 8, max = 8, message = "El dni debe tener 8 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "El dni debe tener solo dígitos")
    @Column(name = "Dni", nullable = false, length = 8)
    private String dni;

    @Size(max = 9)
    @NotNull
    @Size(min = 9, max = 9, message = "El teléfono debe tener 9 digitos")
    @Pattern(regexp = "^[0-9]+$", message = "El teléfono debe tener solo dígitos")
    @Column(name = "Phone", nullable = false, length = 9)
    private String phone;

    @NotNull
    @Digits(integer = 3,fraction = 0)
    @Positive
    @Column(name = "Age", nullable = false)
    private Integer age;

}