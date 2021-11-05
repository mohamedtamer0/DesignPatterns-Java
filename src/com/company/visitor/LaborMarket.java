package com.company.visitor;

import java.util.ArrayList;
import java.util.List;

public class LaborMarket {

    List<Applicant> applicants = new ArrayList<>();

    {
        applicants.add(new Student("Tamer",  3.2, "Computer Science"));
        applicants.add(new Student("Mohamed",  3.4, "Network Engineer"));
        applicants.add(new Student("Habiba",  3.4, "Computer Science"));
        applicants.add(new Engineer("Ahmed",  4, 15));
        applicants.add(new Engineer("Mohand",  3, 10));
        applicants.add(new Engineer("Mohab",  6, 20));
    }


    public void showApplicants(Interviewer visitor) {
        for (Applicant applicant : applicants) {
            applicant.accept(visitor);
        }
    }
}
