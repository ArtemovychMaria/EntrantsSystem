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

    @Column(name = "first_subject_grade")
    private int subjectGrade1;
    @Column(name = "second_subject_grade")
    private int subjectGrade2;
    @Column(name = "third_subject_grade")
    private int subjectGrade3;

    @Column(name = "certificate_grade")
    private double averageGradeOfCertificate;

    @Column(name = "final_grade")
    private double finalGrade;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

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

    public int getSubjectGrade1() {
        return subjectGrade1;
    }

    public void setSubjectGrade1(int subjectGrade1) {
        this.subjectGrade1 = subjectGrade1;
    }

    public int getSubjectGrade2() {
        return subjectGrade2;
    }

    public void setSubjectGrade2(int subjectGrade2) {
        this.subjectGrade2 = subjectGrade2;
    }

    public int getSubjectGrade3() {
        return subjectGrade3;
    }

    public void setSubjectGrade3(int subjectGrade3) {
        this.subjectGrade3 = subjectGrade3;
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
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
