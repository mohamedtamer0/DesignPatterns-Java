package com.company.template_method;

public class RadioAssemblyLine extends AssemblyLine{

    @Override
    protected void onProduceComponents() {
        System.out.println("Product Radio Components and Antennas");
    }
}
