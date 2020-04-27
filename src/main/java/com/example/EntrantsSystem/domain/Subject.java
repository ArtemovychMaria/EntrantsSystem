package com.example.EntrantsSystem.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    int id;
    String name;

    @ManyToMany(mappedBy = "requiredSubjects")
    Set<Faculty> faculties;
}
