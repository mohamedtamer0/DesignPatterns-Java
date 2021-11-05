package com.company.visitor;

public interface Applicant {
    void accept(Interviewer visitor);
}
