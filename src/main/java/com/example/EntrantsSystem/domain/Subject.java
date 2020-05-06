package com.example.EntrantsSystem.domain;

import javax.persistence.*;
import java.util.HashSet;
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
    Set<Faculty> faculties=new HashSet<Faculty>();

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty){
        this.faculties.add(faculty);
    }
}
