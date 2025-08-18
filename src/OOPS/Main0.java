package OOPS;


 class Student {
    String name;
    int rollNumber;
    float marks;

    public Student(String name, int rollNumber, float marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }
}




public class Main0 {
    public static void main(String[] args) {
        Student s1 = new Student("Avinash", 101, 90.5f);
        Student s2 = new Student("Bharath", 102, 85.0f);

        s1.displayDetails();
        s2.displayDetails();
    }
}
