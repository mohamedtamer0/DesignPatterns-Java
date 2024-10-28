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

>In software engineering, creational design patterns are design patterns that deal with object creation mechanisms, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by somehow controlling this object creation.
>

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

>In software engineering, structural design patterns are design patterns that ease the design by identifying a simple way to realize relationships between entities.
>

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


## Flyweight
Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/flyweight.png"/>

### Example:

```java
public interface Ticket {
    public void printTicket(String time, String seat);
}

```

```java
public class TicketFactory {

    private static Map<String, Ticket> map = new ConcurrentHashMap<>();

    public static Ticket getTicket(String movieName) {
        if (map.containsKey(movieName)) {
            return map.get(movieName);
        } else {
            Ticket ticket = new MovieTicket(movieName);
            map.put(movieName, ticket);
            return ticket;
        }
    }

}

```

```java
public class MovieTicket implements Ticket {

    private String movieName;
    private String price;

    public MovieTicket(String movieName){
        this.movieName = movieName;
        price = "Price " + new Random().nextInt(100);
    }

    @Override

    public void printTicket(String time, String seat) {
        System.out.println("+-------------------+");
        System.out.printf("| %-12s    |\n", movieName);
        System.out.println("|                   |");
        System.out.printf("|       %-12s|\n", time);
        System.out.printf("|       %-12s|\n", seat);
        System.out.printf("|       %-12s|\n", price);
        System.out.println("|                   |");
        System.out.println("+-------------------+");
    }
}

```



### Usage :

```java
    MovieTicket movieTicket1 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
    movieTicket1.printTicket("14:00-16:30", "Seat  D-5");
    MovieTicket movieTicket2 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
    movieTicket2.printTicket("14:00-16:30", "Seat  F-6");
    MovieTicket movieTicket3 = (MovieTicket) TicketFactory.getTicket("Transformers 5");
    movieTicket3.printTicket("18:00-22:30", "Seat  A-2");
```

### Outpu:

```code
+-------------------+
| Transformers 5    |
|                   |
|       14:00-16:30 |
|       Seat  D-5   |
|       Price 33    |
|                   |
+-------------------+
+-------------------+
| Transformers 5    |
|                   |
|       14:00-16:30 |
|       Seat  F-6   |
|       Price 33    |
|                   |
+-------------------+
+-------------------+
| Transformers 5    |
|                   |
|       18:00-22:30 |
|       Seat  A-2   |
|       Price 33    |
|                   |
+-------------------+

```




##
## Behavioral Patterns : 

>In software engineering, behavioral design patterns are design patterns that identify common communication patterns between objects and realize these patterns. By doing so, these patterns increase flexibility in carrying out this communication.
>


## Template Method
Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/template_method.png"/>

### Example:

```java
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

```

```java
public class ComputerAssemblyLine extends AssemblyLine{

    @Override
    protected void onProduceShell() {
        System.out.println("Product Aluminum housing and Liquid Crystal Display");
    }

    @Override
    protected void onProduceComponents() {
        System.out.println("Product Components and keyboard");
    }

    @Override
    protected void onProductPacking() {
        System.out.println("Pack and Mark the Apple trademark");
    }
}
```

```java
public class RadioAssemblyLine extends AssemblyLine{

    @Override
    protected void onProduceComponents() {
        System.out.println("Product Radio Components and Antennas");
    }
}


```



### Usage :

```java
    AssemblyLine assemblyLine = new ComputerAssemblyLine();
    assemblyLine.product();

    System.out.println();

    assemblyLine = new RadioAssemblyLine();
    assemblyLine.product();
```

### Outpu:

```code
+------Start Product------+
Product Aluminum housing and Liquid Crystal Display
Product Components and keyboard
Assembly Components
Test Products
Product Components and keyboard
Pack and Mark the Apple trademark
+------Finish Product------+

+------Start Product------+
Produce Shell
Product Radio Components and Antennas
Assembly Components
Test Products
Product Radio Components and Antennas
Product Packing
+------Finish Product------+

```


## Chain of Responsibility
The chain of responsibility pattern is used to process varied requests, each of which may be dealt with by a different handler.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/chain_of_responsibility.png"/>

### Example:

```java
public abstract class Handler {

    protected Handler successor;

    public abstract int capital();

    public abstract void handle(int money);

    public final void handleRequest(int money) {
        if (money <= capital()) {
            handle(money);
        }else {
            if (null != successor) {
                successor.handleRequest(money);
            }else {
                System.out.println("Your requested funds could not be approved");
            }
        }
    }

}

```

```java
public class Tutor extends Handler{
    @Override
    public int capital() {
        return 100;
    }

    @Override
    public void handle(int money) {
        System.out.println("Approved by the instructor: approved " + money + " Dollar");
    }
}
```

```java
public class Secretary extends Handler {
    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Secretary approved: approved " + money + " Dollar");
    }
}


```

```java
public class Principal extends Handler {
    @Override
    public int capital() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Approved by the principal: approved " + money + " Dollar");
    }
}


```

```java
public class Dean extends Handler {
    @Override
    public int capital() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("Dean approved: approved " + money + " Dollar");
    }
}

```



### Usage :

```java
        Tutor tutor = new Tutor();
        Secretary secretary = new Secretary();
        Dean dean = new Dean();
        Principal principal = new Principal();

        tutor.successor = secretary;
        secretary.successor = dean;
        dean.successor = principal;
        principal.successor = null;

        tutor.handleRequest(12000);
        secretary.handleRequest(100);
```

### Outpu:

```code
Your requested funds could not be approved
Secretary approved: approved 100 Dollar

```



## Command
The command pattern is used to express a request, including the call to be made and all of its required parameters, in a command object. The command may then be executed immediately or held for later use.

## UML :

<img src="https://user-images.githubusercontent.com/51374446/140611296-48c950e8-1969-4b77-a260-adc682472754.png"/>


### Example:

```java
public interface OrderCommand {
    void execute();
}

```

```java
public class OrderPayCommand implements OrderCommand{

    public Long id;

    public OrderPayCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Paying for order with id : " + id);
    }
}

```

```java
public class OrderAddCommand implements OrderCommand{
    public Long id;

    public OrderAddCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Adding Order With id : " + id);
    }
}

```

```java
public class CommandProcessor {

    ArrayList<OrderCommand> queue = new ArrayList<>();

    public void addToQueue(OrderCommand orderCommand) {
        queue.add(orderCommand);
    }

    public void processCommands() {
        queue.forEach(OrderCommand::execute);
        queue.clear();
    }
}

```


### Usage :

```java
    CommandProcessor obj = new CommandProcessor();
    obj.addToQueue(new OrderAddCommand(1L));
    obj.addToQueue(new OrderAddCommand(2L));
    obj.addToQueue(new OrderPayCommand(2L));
    obj.addToQueue(new OrderPayCommand(1L));
    obj.processCommands();
```

### Outpu:

```code
Adding Order With id : 1
Adding Order With id : 2
Paying for order with id : 2
Paying for order with id : 1

```



## Iterator
Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/iterator.png"/>


### Example:

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

```

```java
public interface BookIterable<T> {
    Iterator<T> iterator();
}

```

```java
public class Book {

    private String name;
    private String ISBN;
    private String press;

    public Book(String name, String ISBN, String press) {
        this.name = name;
        this.ISBN = ISBN;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", press='" + press + '\'' +
                '}';
    }

        /*
        Don't forget geeter and setter !!!!
        */
```

```java
public class Literature implements BookIterable{

    private Book[] literature;

    public Literature() {
        literature = new Book[4];
        literature[0] = new Book("Three Kingdoms", "9787532237357", "Shanghai People's Fine Arts Publishing House");
        literature[1] = new Book("Journey to the West", "9787805200552", "Yuelu Publishing House");
        literature[2] = new Book("Water Margin", "9787020015016", "People's Literature Publishing House");
        literature[3] = new Book("Dream of Red Mansions", "9787020002207", "People's Literature Publishing House");
    }

    public Book[] getLiterature() {
        return literature;
    }

    @Override
    public Iterator iterator() {
        return new LiteratureIterator(literature);
    }
}
```

```java
public class LiteratureIterator  implements Iterator{


    private Book[] literatures;

    private int index;

    public LiteratureIterator(Book[] literatures) {
        this.literatures = literatures;
    }

    @Override
    public boolean hasNext() {
        return (index < literatures.length - 1 && literatures[index] != null);
    }

    @Override
    public Book next() {
        return literatures[index++];
    }
}
```



### Usage :

```java
    public static void main(String[] args) {
        Literature literature = new Literature();
        itr(literature.iterator());
        
    }

    private static void itr(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
```

### Outpu:

```code
Book{name='Three Kingdoms', ISBN='9787532237357', press='Shanghai People's Fine Arts Publishing House'}
Book{name='Journey to the West', ISBN='9787805200552', press='Yuelu Publishing House'}
Book{name='Water Margin', ISBN='9787020015016', press='People's Literature Publishing House'}
```



## Mediator
Mediator design pattern is used to provide a centralized communication medium between different objects in a system. This pattern is very helpful in an enterprise application where multiple objects are interacting with each other.

## UML :

<img src="https://upload.wikimedia.org/wikipedia/commons/e/e4/Mediator_design_pattern.png"/>


### Example:

```java
public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

```

```java
public abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator med, String name) {
        this.mediator = med;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}

```

```java
public class ChatMediatorImpl implements ChatMediator {
    private final List<User> users;

    public ChatMediatorImpl() { this.users = new ArrayList<>(); }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User toUser) {
        for (User user : users) {
            //Message should not be received by the user sending it.
            if(user != toUser) { user.receive(msg); }
        }
    }
}
```

```java
public class UserImpl extends User {
    public UserImpl(ChatMediator med, String name) {
        super(med, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + ": Sending Message = " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + ": Message received: " + msg);
    }
}
```



### Usage :

```java
    ChatMediator mediator = new ChatMediatorImpl();
    User user1 = new UserImpl(mediator, "Tamer");
    User user2 = new UserImpl(mediator, "Mohab");
    User user3 = new UserImpl(mediator, "Mohand");
    User user4 = new UserImpl(mediator, "Habiba");

    mediator.addUser(user1);
    mediator.addUser(user2);
    mediator.addUser(user3);
    mediator.addUser(user4);

    user1.send("Hi everyone!");
```

### Outpu:

```code
Mohab: Message received: Hi everyone!
Mohand: Message received: Hi everyone!
Habiba: Message received: Hi everyone!
```




## Memento
The memento pattern is a software design pattern that provides the ability to restore an object to its previous state (undo via rollback).

## UML :

<img src="https://raw.githubusercontent.com/innofang/designpatterns/master/uml/memento.png"/>


### Example:

```java
public class Memento {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public void setDate(String date) {
        mDate = date;
    }

    public String getDate() {
        return mDate;
    }

    public String getTodo() {
        return mTodo;
    }

    public void setTodo(String mTodo) {
        this.mTodo = mTodo;
    }

    public boolean isFinish() {
        return mIsFinish;
    }

    public void setIsFinish(boolean mIsFinish) {
        this.mIsFinish = mIsFinish;
    }

    @Override
    public String toString() {
        return "memento{" +
                "Date='" + mDate + '\'' +
                ", Todo='" + mTodo + '\'' +
                ", IsFinish=" + mIsFinish +
                '}';
    }
}

```

```java
public class Caretaker {
    private Memento mMemoto;

    public void archive(Memento memoto) {
        mMemoto = memoto;
    }

    public Memento getMemoto() {
        return mMemoto;
    }
}

```

```java
public class ToDo {
    private String mDate;
    private String mTodo;
    private boolean mIsFinish;

    public ToDo() {
        mDate = new SimpleDateFormat("yyyy/MM/dd EE HH:mm:ss").format(new Date());
    }

    public void setToDoDetail(String todo, boolean isFinish) {
        mTodo = todo;
        mIsFinish = isFinish;
    }

    public Memento createMemoto() {
        Memento memento = new Memento();
        memento.setDate(mDate);
        memento.setTodo(mTodo);
        memento.setIsFinish(mIsFinish);
        return memento;
    }

    public void restore(Memento memento) {
        mDate = memento.getDate();
        mTodo = memento.getTodo();
        mIsFinish = memento.isFinish();
    }

    public String getDate() {
        return mDate;
    }

    public String getTodo() {
        return mTodo;
    }

    public void setTodo(String mTodo) {
        this.mTodo = mTodo;
    }

    public boolean isIsFinish() {
        return mIsFinish;
    }

    public void setIsFinish(boolean mIsFinish) {
        this.mIsFinish = mIsFinish;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "Date='" + mDate + '\'' +
                ", Todo='" + mTodo + '\'' +
                ", IsFinish=" + mIsFinish +
                '}';
    }
}
```




### Usage :

```java
    ToDo toDo = new ToDo();

    toDo.setToDoDetail("Write Java at 2 pm", false);

    Caretaker caretaker = new Caretaker();
    caretaker.archive(toDo.createMemoto());

    System.out.println(toDo.toString());

    ToDo newToDo = new ToDo();
    newToDo.restore(caretaker.getMemoto());
    newToDo.setIsFinish(true);

    System.out.println(newToDo.toString());
```

### Outpu:

```code
ToDo{Date='2021/11/06 Sat 16:04:55', Todo='Write Java at 2 pm', IsFinish=false}
ToDo{Date='2021/11/06 Sat 16:04:55', Todo='Write Java at 2 pm', IsFinish=true}
```




## Observer
The observer pattern is used to allow an object to publish changes to its state. Other objects subscribe to be immediately notified of any changes.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/observer.png"/>


### Example:

```java
public interface Observer {
    public void update(String magazine);
}

```

```java
public interface Subject {
     void registerObserver(Observer observer);
     void removeObserver(Observer observer);
     void notifyObservers();
}

```

```java
public class Magazine implements Subject{
    private List<Observer> observerList;
    private String magazine;

    public Magazine() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observerList.size(); i++) {
            Observer observer= observerList.get(i);
            observer.update(magazine);
        }
    }
    
    public void setMagazine(String magazine) {
        this.magazine = magazine;
        notifyObservers();
    }

}

```

```java
public class Subscriber implements Observer {

    private final String subscriber;

    public Subscriber(Subject magazine, String subscriber) {
        magazine.registerObserver(this);
        this.subscriber = subscriber;
    }

    @Override
    public void update(String magazine) {
        System.out.println("Dear" + subscriber + ": Your magazine has arrived, and today’s magazine is called《" + magazine +"》");
    }
}
```

```java
public class Bookstore implements Observer{
    public Bookstore(Subject magazine) {
        magazine.registerObserver(this);
    }

    @Override
    public void update(String magazine) {
        System.out.println("Our shop updates the magazine today：《" + magazine+ "》");
    }
}
```



### Usage :

```java
    Magazine magazine = new Magazine();

    Subscriber mohamed = new Subscriber(magazine, "Mohamed");
    Subscriber tamer = new Subscriber(magazine, "Tamer");
    Subscriber habiba = new Subscriber(magazine, "Habiba");
    Bookstore bookstore = new Bookstore(magazine);

    magazine.setMagazine("Shock! Today's magazine since...");
```

### Outpu:

```code
DearMohamed: Your magazine has arrived, and today’s magazine is called《Shock! Today's magazine since...》
DearTamer: Your magazine has arrived, and today’s magazine is called《Shock! Today's magazine since...》
DearHabiba: Your magazine has arrived, and today’s magazine is called《Shock! Today's magazine since...》
Our shop updates the magazine today：《Shock! Today's magazine since...》
```




## State
The state pattern is used to alter the behaviour of an object as its internal state changes. The pattern allows the class for an object to apparently change at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/state.png"/>


### Example:

```java
public interface GameState {
    void killMonster();
    void gainExperience();
    void next();
    void pick();
}

```

```java
public class Player {

    GameState state;

    public void setState(GameState state) {
        this.state = state;
    }

    public void gameStart() {
        setState(new GameStartState());
        System.out.println("\n-----Game Start, ready to fight-----\n");
    }

    public void gameOver() {
        setState(new GameOverState());
        System.out.println("\n-----         Game Over        -----\n");
    }

    public void killMonster() {
        state.killMonster();
    }

    public void gainExperience() {
        state.gainExperience();
    }

    public void next() {
        state.next();
    }

    public void pick() {
        state.pick();
    }
    
}

```

```java
public class GameStartState implements GameState {

    @Override
    public void killMonster() {
        System.out.println("Kill a Monster");
    }
    
    @Override
    public void gainExperience() {
        System.out.println("Gain 5 EXP");
    }
    
    @Override
    public void next() {
        System.out.println("Good! please enter next level");
    }
    
    @Override
    public void pick() {
        System.out.println("Wow! You pick a good thing");
    }
}

```

```java
public class GameOverState implements GameState {

    @Override
    public void killMonster() {
        System.out.println("Please start game first");
    }

    @Override
    public void gainExperience() {}

    @Override
    public void next() {
        System.out.println("You want to challenge again?");
    }

    @Override
    public void pick() {
        System.out.println("Please start game first");
    }
}
```



### Usage :

```java
    Player player = new Player();
    player.gameStart();
    player.killMonster();
    player.gainExperience();
    player.next();
    player.pick();
    player.gameOver();
    player.next();
    player.killMonster();
    player.pick();
```

### Outpu:

```code
-----Game Start, ready to fight-----

Kill a Monster
Gain 5 EXP
Good! please enter next level
Wow! You pick a good thing

-----         Game Over        -----

You want to challenge again?
Please start game first
Please start game first

```




## Strategy
The strategy pattern is used to create an interchangeable family of algorithms from which the required process is chosen at run-time.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/strategy.png"/>


### Example:

```java
public interface Strategy {
    void transportation();
}
```

```java
public class Context {
    private Strategy goToStrategy;
    
    public void setGoToStrategy(Strategy strategy) {
        this.goToStrategy = strategy;
    }

    public void take() {
        goToStrategy.transportation();
    }
}

```

```java
public class GoToCairo implements Strategy{
    @Override
    public void transportation() {
        System.out.println("take my car");
    }
}
```

```java
public class GoToGona implements Strategy{
    @Override
    public void transportation() {
        System.out.println("take plane");
    }
}
```



### Usage :

```java
    Context context = new Context();

    context.setGoToStrategy(new GoToCairo());
    context.take();

    context.setGoToStrategy(new GoToGona());
    context.take();
```

### Outpu:

```code
take my car
take plane

```




## Visitor
The visitor pattern is used to separate a relatively complex set of structured data classes from the functionality that may be performed upon the data that they hold.

## UML :

<img src="https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/visitor.png"/>


### Example:

```java
public interface Interviewer {
    void visit(Student student);
    void visit(Engineer engineer);
}

```

```java
public interface Applicant {
    void accept(Interviewer visitor);
}
```

```java
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
```

```java
public class Student implements Applicant{
    private String name;
    private double gpa;
    private String major;

    public Student(String name, double gpa, String major) {
        this.name = name;
        this.gpa = gpa;
        this.major = major;
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


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
```

```java
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
```

```java
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

```



### Usage :

```java
    LaborMarket laborMarket = new LaborMarket();
    System.out.println("===== Round 1: Leader =====");
    laborMarket.showApplicants(new Leader());

    /*
    You can add more rounds and implements .............
     */
```

### Outpu:

```code
===== Round 1: Leader =====
Student  Tamer's gpa is 3.2
Student  Mohamed's gpa is 3.4
Student  Habiba's gpa is 3.4
Engineer  Ahmed's number of projects is 15
Engineer  Mohand's number of projects is 10
Engineer  Mohab's number of projects is 20

```











