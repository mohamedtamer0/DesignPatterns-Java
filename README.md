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
