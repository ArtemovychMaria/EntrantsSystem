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
    @Column(name = "budget_plan")
    int budgetPlan;
    @Column(name = "commercial_plan")
    int commercialPlan;

    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name = "faculty_subject",
            joinColumns = @JoinColumn(name = "faculty_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> requiredSubjects=new HashSet<Subject>();

    public Faculty() {
    }

    public Faculty(String name, int budgetPlan,int commercialPlan) {
        this.name = name;
        this.budgetPlan=budgetPlan;
        this.commercialPlan=commercialPlan;
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

    public int getBudgetPlan() {
        return budgetPlan;
    }

    public void setBudgetPlan(int budgetPlan) {
        this.budgetPlan = budgetPlan;
    }

    public int getCommercialPlan() {
        return commercialPlan;
    }

    public void setCommercialPlan(int commercialPlan) {
        this.commercialPlan = commercialPlan;
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
