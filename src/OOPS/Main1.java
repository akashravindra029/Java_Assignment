package OOPS;



class Animal {
    void sound() {
        System.out.println("animal make sound");
    }
}


class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}


public class Main1 {
    public static void main(String[] args) {
        Dog d = new Dog();     // Create Dog object
        d.sound();             // Call sound() method
    }
}
