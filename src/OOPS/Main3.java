package OOPS;

// Base class
class Shape {
    void draw() {
        System.out.println("Drawing a Shape");
    }
}


class Circle extends Shape {

    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square extends Shape {

    void draw() {
        System.out.println("Drawing a Square");
    }
}


public class Main3 {
    public static void main(String[] args) {
        // Shape reference pointing to a Circle object
        Shape s1 = new Circle();
        s1.draw();


        Shape s2 = new Square();
        s2.draw();

       // Shape s3 = new Shape();
       //s3.draw();


    }
}

