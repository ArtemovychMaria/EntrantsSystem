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

    @Column(name = "summary_subjects_grade")
    private int summarySubjectsGrade;

    @Column(name = "certificate_grade")
    private double averageGradeOfCertificate;

    @Column(name = "final_grade")
    private double finalGrade;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "rejected")
    private boolean rejected;

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

    public int getSummarySubjectsGrade() {
        return summarySubjectsGrade;
    }

    public void setSummarySubjectsGrade(int summarySubjectsGrade) {
        this.summarySubjectsGrade = summarySubjectsGrade;
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

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }
}
