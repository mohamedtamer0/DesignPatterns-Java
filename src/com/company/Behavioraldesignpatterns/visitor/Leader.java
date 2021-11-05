package com.company.Behavioraldesignpatterns.visitor;

public class Leader implements Interviewer {
    @Override
    public void visit(Student student) {
        System.out.println("Student  " + student.getName() + "'s gpa is " + student.getGpa());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer  " + engineer.getName() + "'s number of projects is " + engineer.getProjectNumber());
    }
}