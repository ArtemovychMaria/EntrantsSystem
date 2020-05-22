package com.example.EntrantsSystem.dto;

public class StatementDto {

    int facultyId;
    int subjectGrade1;
    int subjectGrade2;
    int subjectGrade3;
    double certificateGrade;

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
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

    public double getCertificateGrade() {
        return certificateGrade;
    }

    public void setCertificateGrade(double certificateGrade) {
        this.certificateGrade = certificateGrade;
    }
}
