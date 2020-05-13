package com.example.EntrantsSystem.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private int id;
    String name;
    @Column(name = "number_of_students")
    int numberOfStudents;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "faculty_subject",
            joinColumns = @JoinColumn(name = "faculty_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> requiredSubjects=new HashSet<Subject>();

    public Faculty() {
    }

    public Faculty(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
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

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Set<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(Set<Subject> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public void addSubject(Subject subject){
        this.requiredSubjects.add(subject);
    }
}
