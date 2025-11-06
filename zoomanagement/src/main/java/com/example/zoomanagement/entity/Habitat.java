package com.example.zoomanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "habitats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Habitat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int capacity;

    @OneToMany(mappedBy = "habitat", cascade = CascadeType.ALL)
    private Set<Animal> animals = new HashSet<>();

}