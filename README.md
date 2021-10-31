# DesignPatterns-Java

## Design Patterns
- In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. It is a description or template for how to solve a problem that can be used in many different situations.
## Creational design patterns
- Singleton
- Prototype
- Object Pool
- Factory Method
- Builder
- Abstract Factory

## Structural design patterns
- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Private Class Data
- Proxy

## Behavioral design patterns
- Chain of responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Null Object
- Observer
- State
- Strategy
- Template method
- Visitor



## Creational design patterns

### Singleton

The singleton pattern ensures that only one object of a particular class is ever created. All further references to objects of the singleton class refer to the same underlying instance. There are very few applications, do not overuse this pattern!

## UML :

<img src="https://user-images.githubusercontent.com/51374446/139603038-66b99d0b-9c34-4f6f-ae14-5277fd2a814b.jpg" style="width:300px;height:300px"/>

### Example:

```java
public class Counter {

    public int count = 0;

    private static Counter instance = new Counter();

    private Counter() {
    }

    public static Counter getInstance() {
        return instance;
    }

    public void addOne() {
        count++;
    }
}
```

### Usage :

```java
    Counter obj1 = Counter.getInstance();
    Counter obj2 = Counter.getInstance();
    obj1.addOne();
    obj2.addOne();
    System.out.println("Counter 1 : " + obj1.count);
    System.out.println("Counter 2 : " + obj2.count);

    obj1.addOne();
    obj2.addOne();
    System.out.println("Counter 1 : " + obj1.count);
    System.out.println("Counter 2 : " + obj2.count);
```

### Output :

```code
Counter 1 : 2
Counter 2 : 2
Counter 1 : 4
Counter 2 : 4
```

##
## prototype
The Prototype pattern delegates the cloning process to the actual objects that are being cloned. The pattern declares a common interface for all objects that support cloning. This interface lets you clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.

The implementation of the clone method is very similar in all classes. The method creates an object of the current class and carries over all of the field values of the old object into the new one. You can even copy private fields because most programming languages let objects access private fields of other objects that belong to the same class.

An object that supports cloning is called a prototype. When your objects have dozens of fields and hundreds of possible configurations, cloning them might serve as an alternative to subclassing.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/prototype.png"/>

### Example:


```java
import java.util.ArrayList;

public class WordDocument implements Cloneable {

    private String text;
    private ArrayList<String> images = new ArrayList<>();

    public WordDocument() {
        System.out.println("-----Init-----");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void addImage(String image) {
        images.add(image);
    }

    public void showDocument() {
        System.out.println("-----Start-----");
        System.out.println("Text : " + text);
        System.out.println("Image List : ");
        for (String mImage : images) {
            System.out.println("Image Name : " + mImage);
        }
        System.out.println("-----End-----");
    }

    protected WordDocument clone() {
        try {
            WordDocument copy = (WordDocument) super.clone();
            copy.text = this.text;
//            copy.images = this.images;
            copy.images = (ArrayList<String>) this.images.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

```

### Usage :

```java
public static void main(String[] args) {
    WordDocument originDoc = new WordDocument();
    originDoc.setText("This is a document");
    originDoc.addImage("Image 1");
    originDoc.addImage("Image 2");
    originDoc.addImage("Image 3");
    originDoc.showDocument();

    WordDocument copyDoc = originDoc.clone();
    copyDoc.showDocument();

    copyDoc.setText("This is a copy document");

    // add this line to test the origin document what will happen after the copy document add a image
    copyDoc.addImage("a new Image");


    copyDoc.showDocument();
    copyDoc.showDocument();
}
```
## Output:

```code
-----Init-----
-----Start-----
Text: This is a document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
-----End-----
-----Start-----
Text: This is a document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
-----End-----
-----Start-----
Text: This is a copy document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
Image name: A new image
-----End-----
-----Start-----
Text: This is a copy document
Images List: 
Image name: Image 1
Image name: Image 2
Image name: Image 3
Image name: A new image
-----End-----

```

##
## Builder
The builder pattern is used to create complex objects with constituent parts that must be created in the same order or using a specific algorithm. An external class controls the construction algorithm.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/builder.png"/>

### Example:

```java
public class Car {
    private String color;
    private String licensePlate;
    private String brand;

    public void setColor(String color) {
        this.color = color;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}

```

```java
public interface Builder {
    void builderColor(String color);

    void builderLicensePlate(String licensePlate);

    void builderBrand(String brand);

    Car build();
}

```

```java
public class CarBuilder implements Builder {

    Car car;

    public CarBuilder() {
        car = new Car();
    }

    @Override
    public void builderColor(String color) {
        car.setColor(color);
    }

    @Override
    public void builderLicensePlate(String licensePlate) {
        car.setLicensePlate(licensePlate);
    }

    @Override
    public void builderBrand(String brand) {
        car.setBrand(brand);
    }

    @Override
    public Car build() {
        return car;
    }
}

```

```java
public class Director {

    Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }


    public void construct(String color, String licensePlate, String brand) {
        builder.builderColor(color);
        builder.builderLicensePlate(licensePlate);
        builder.builderBrand(brand);
    }
}

```

### Usage :

```java
    Builder builder = new CarBuilder();
    Director director = new Director(builder);
    director.construct("Red","A88888","Ferrari");
    System.out.println(builder.build().toString());
```

### Outpu:

```code
Car{color='Red', licensePlate='A88888', brand='Ferrari'}
```




##
## Factory Method
The factory pattern is used to replace class constructors, abstracting the process of object generation so that the type of the object instantiated can be determined at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/factory_method.png"/>

### Example:

```java
public interface Cake {
    void prepareMaterials();

    void baking();
}

```

```java
public class MangoCake implements Cake{
    @Override
    public void prepareMaterials() {
        System.out.println("prepare Mango Cream");
    }

    @Override
    public void baking() {
        System.out.println("Baking ten minutes");
    }
}

```

```java
public abstract class Factory {
    public abstract <T extends Cake> T createProduct(Class<T> clz);
}

```

```java
public class CakeFactory extends Factory{

    @Override
    public <T extends Cake> T createProduct(Class<T> clz) {
        Cake cake = null;
        try {
            cake = (Cake) Class.forName(clz.getName()).getDeclaredConstructor().newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  (T) cake;
    }
}


```



### Usage :

```java
    Factory factory = new CakeFactory();
    MangoCake mangoCake = factory.createProduct(MangoCake.class);
    mangoCake.prepareMaterials();
    mangoCake.baking();
```

### Outpu:

```code
prepare Mango Cream
Baking ten minutes
```




##
## Abstract Factory
The abstract factory pattern is used to provide a client with a set of related or dependant objects. The "family" of objects created by the factory are determined at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/abstract_factory.png"/>

### Example:

```java
public abstract class CakeFactory {
    public abstract CakeCream cream();
    public abstract CakeStyle style();
}

```

```java
public abstract class CakeCream {
    public abstract void cream();
}

```

```java
public abstract class CakeStyle {
    public abstract void style();
}

```

```java
public class HeartStyle extends CakeStyle{
    @Override
    public void style() {
        System.out.println("Heart Style");
    }
}

```

```java
public class MangoCream extends CakeCream{
    @Override
    public void cream() {
        System.out.println("Mango Cream");
    }
}


```

```java
public class MangoHeartCake extends CakeFactory{
    @Override
    public CakeCream cream() {
        return new MangoCream() ;
    }

    @Override
    public CakeStyle style() {
        return new HeartStyle();
    }
}


```




### Usage :

```java
    CakeFactory mangoHeartCake  = new MangoHeartCake();
    mangoHeartCake.cream().cream();
    mangoHeartCake.style().style();

    System.out.println("=================");

    CakeFactory mangoSquareCake = new MangoSquareCake();
    mangoSquareCake.cream().cream();
    mangoSquareCake.style().style();
```

### Outpu:

```code
Mango Cream
Heart Style
=================
Mango Cream
Square Style
```


##
## Structural Patterns : 

## Protection Proxy
The proxy pattern is used to provide a surrogate or placeholder object, which references an underlying object. Protection proxy is restricting access.


## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/proxy.png"/>

### Example:

```java
public interface IPicker {
    void receiveMessage();

    void takeCourier();

    void signatureAcceptance();

}

```

```java
public class RealPicker implements IPicker{
    @Override
    public void receiveMessage() {
        System.out.println("Receive text Message");
    }

    @Override
    public void takeCourier() {
        System.out.println("Take the Courier");
    }

    @Override
    public void signatureAcceptance() {
        System.out.println("Signature Acceptance");
    }
}


```

```java
public class ProxyPicker implements IPicker {

    private IPicker picker;

    public ProxyPicker(IPicker picker) {
        this.picker = picker;
    }

    @Override
    public void receiveMessage() {
        picker.receiveMessage();
    }

    @Override
    public void takeCourier() {
        picker.takeCourier();
    }

    @Override
    public void signatureAcceptance() {
        picker.signatureAcceptance();
    }
}

```



### Usage :

```java
    IPicker picker = new RealPicker();
    ProxyPicker proxyPicker = new ProxyPicker(picker);

    proxyPicker.receiveMessage();
    proxyPicker.takeCourier();
    proxyPicker.signatureAcceptance();
```

### Outpu:

```code
Receive text Message
Take the Courier
Signature Acceptance
```



## Decorator
The decorator pattern is used to extend or alter the functionality of objects at run-time by wrapping them in an object of a decorator class. This provides a flexible alternative to using inheritance to modify behaviour.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/decorator.png"/>

### Example:

```java
public interface Cake {

    void make();
}

```

```java
public class CakeEmbryo implements Cake{
    @Override
    public void make() {
        System.out.println("Baking Cake");
    }
}

```

```java
public abstract class DecoratorCake implements Cake {
    Cake cake;

    public DecoratorCake(Cake cake) {
        this.cake = cake;
    }

    @Override
    public void make() {
        cake.make();
    }
}

```

```java
public class FruitCake extends DecoratorCake{

    public FruitCake(Cake cake) {
        super(cake);
    }

    @Override
    public void make() {
        addSomeFruit();
        super.make();
    }

    private void addSomeFruit(){
        System.out.println("Add Some fruit");
    }
}

```



### Usage :

```java
    Cake cake = new CakeEmbryo();
    cake.make();

    System.out.println("--------Decorate Fruit Cake--------");
    DecoratorCake fruitCake = new FruitCake(cake);
    fruitCake.make();
```

### Outpu:

```code
Baking Cake
--------Decorate Fruit Cake--------
Add Some fruit
Baking Cake
```


## Adapter
The adapter pattern is used to provide a link between two otherwise incompatible types by wrapping the "adaptee" with a class that supports the interface required by the client.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/class_adapter.png"/>

### Example:

```java
public interface VoltFive {
    int provideVoltFive();
}

```

```java
public class Volt220 {
    public int provideVolt220(){
        return 220;
    }
}

```

```java
public class VoltAdapter implements VoltFive{

    private Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int provideVoltFive() {
        int volt = volt220.provideVolt220();
        return 5;
    }

    public int provideVolt220() {
        return  volt220.provideVolt220();
    }

}

```


### Usage :

```java
    Volt220 volt220 = new Volt220();
    VoltAdapter adapter = new VoltAdapter(volt220);

    int volt = adapter.provideVoltFive();
    System.out.println("After adapter, the volt is :" + volt);
```

### Outpu:

```code
After adapter, the volt is :5
```




## Facade
The facade pattern is used to define a simplified interface to a more complex subsystem.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/facade.png"/>

### Example:

```java
public interface Italykitchen {

    void lasagneWithTomatoAndCheese();

    void prawnRisotto();

    void creamCaramel();


}

```

```java
public class ItalykitchenImpl implements Italykitchen{
    @Override
    public void lasagneWithTomatoAndCheese() {
        System.out.println("Lasagne With Tomato And Cheese");
    }

    @Override
    public void prawnRisotto() {
        System.out.println("Prawn Risotto");
    }

    @Override
    public void creamCaramel() {
        System.out.println("Cream Caramel");
    }
}

```

```java
public interface Frenchkitchen {

     void bouillabaisse();

     void cassoulet();

     void pouleAuPot();
}


```

```java
public class FrenchkitchenImpl implements Frenchkitchen{
    @Override
    public void bouillabaisse() {
        System.out.println("Bouillabaisse");
    }

    @Override
    public void cassoulet() {
        System.out.println("Cassoulet");
    }

    @Override
    public void pouleAuPot() {
        System.out.println("PouleAuPot");
    }
}


```

```java
public class Menu {
    private  Italykitchen italykitchen;
    private Frenchkitchen frenchkitchen;

    public Menu() {
        italykitchen = new ItalykitchenImpl();
        frenchkitchen = new FrenchkitchenImpl();
    }


    public void bouillabaisse() {
        frenchkitchen.bouillabaisse();
    }

    public void cassoulet() {
        frenchkitchen.cassoulet();
    }

    public void pouleAuPot() {
        frenchkitchen.pouleAuPot();
    }

    public void lasagneWithTomatoAndCheese() {
        italykitchen.lasagneWithTomatoAndCheese();
    }

    public void prawnRisotto() {
        italykitchen.prawnRisotto();
    }

    public void creamCaramel() {
        italykitchen.creamCaramel();
    }


}

```


### Usage :

```java
    Menu menu = new Menu();

    System.out.println("Customer order");
    menu.lasagneWithTomatoAndCheese();
    menu.creamCaramel();

    System.out.println("===========New Order==========");
    System.out.println("Customer two orders");
    menu.bouillabaisse();
    menu.prawnRisotto();
```

### Outpu:

```code
Customer order
Lasagne With Tomato And Cheese
Cream Caramel
===========New Order==========
Customer two orders
Bouillabaisse
Prawn Risotto
```













