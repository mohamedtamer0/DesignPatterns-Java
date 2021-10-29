package com.company.Prototype;


import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable {
    List<String> emp;

    Employees() {
        emp = new ArrayList<>();
    }

    Employees(List<String> emp) {
        this.emp = emp;
    }

    void loaddata() {
        emp.add("Ahmed");
        emp.add("Sayed");
        emp.add("Mohamed");
        emp.add("Abdallah");
    }

    List<String> getEmpList() {
        return emp;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s : this.getEmpList()) {
            temp.add(s);
        }
        return new Employees(temp);
    }


    public static void main(String[] args)
            throws CloneNotSupportedException {

        Employees employes = new Employees();
        employes.loaddata();

        Employees emps1 = (Employees) employes.clone();
        Employees emps2 = (Employees) employes.clone();
        List<String> list = emps1.getEmpList();
        list.add("Ebrahim");

        emps2.getEmpList().remove("Mohamed");

        System.out.println("First list: " + employes.getEmpList());
        System.out.println("emps1 list: " + list);
        System.out.println("emps2 list: " + emps2.getEmpList());

    }
}