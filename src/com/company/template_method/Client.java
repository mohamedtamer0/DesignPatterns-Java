package com.company.template_method;

public class Client {
    public static void main(String[] args) {
        AssemblyLine assemblyLine = new ComputerAssemblyLine();
        assemblyLine.product();

        System.out.println();

        assemblyLine = new RadioAssemblyLine();
        assemblyLine.product();


    }
}
