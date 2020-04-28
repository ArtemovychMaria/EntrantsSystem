package com.example.EntrantsSystem.domain;


import javax.persistence.*;

@Entity
@Table(name = "statements")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "summary_grade_of_subjects")
    private double summaryGradeOfSubjects;

    @Column(name = "certificate_grade")
    private double averageGradeOfCertificate;

    @Column(name = "final_grade")
    private double finalGrade;

    public Statement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public double getSummaryGradeOfSubjects() {
        return summaryGradeOfSubjects;
    }

    public void setSummaryGradeOfSubjects(double summaryGradeOfSubjects) {
        this.summaryGradeOfSubjects = summaryGradeOfSubjects;
    }

    public double getAverageGradeOfCertificate() {
        return averageGradeOfCertificate;
    }

    public void setAverageGradeOfCertificate(double averageGradeOfCertificate) {
        this.averageGradeOfCertificate = averageGradeOfCertificate;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
}
