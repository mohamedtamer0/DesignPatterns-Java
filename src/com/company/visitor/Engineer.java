package com.company.visitor;

public class Engineer implements Applicant {

    private String name;
    private int workExperience;
    private int projectNumber;

    public Engineer(String name, int workExperience, int projectNumber) {
        this.name = name;
        this.workExperience = workExperience;
        this.projectNumber = projectNumber;
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

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }
}
