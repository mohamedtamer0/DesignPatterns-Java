package com.company.visitor;

public class Student implements Applicant{
    private String name;
    private double gpa;
    private String major;

    public Student(String name, double gpa, String major) {
        this.name = name;
        this.gpa = gpa;
        this.major = major;
    }

    @Override
    public void accept(Interviewer visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
