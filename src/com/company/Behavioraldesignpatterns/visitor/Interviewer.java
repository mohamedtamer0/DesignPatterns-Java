package com.company.Behavioraldesignpatterns.visitor;

public interface Interviewer {
    void visit(Student student);
    void visit(Engineer engineer);

}
