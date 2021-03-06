package com.company.Behavioraldesignpatterns.template_method;

public abstract class AssemblyLine {


    protected void onProduceShell() {
        System.out.println("Produce Shell");
    }

    protected void onProduceComponents() {
        System.out.println("Produce some components");
    }

    protected void onAssemblyComponents() {
        System.out.println("Assembly Components");
    }

    protected void onTestProducts() {
        System.out.println("Test Products");
    }

    protected void onProductPacking() {
        System.out.println("Product Packing");
    }

    public final void product() {
        System.out.println("+------Start Product------+");
        onProduceShell();
        onProduceComponents();
        onAssemblyComponents();
        onTestProducts();
        onProduceComponents();
        onProductPacking();
        System.out.println("+------Finish Product------+");
    }

}


