import java.util.*;

// Abstraction using Interface
interface DatabaseOperations {
    void addStudent(Student student);
    void viewStudents();
    void updateStudent(int id, String newCourse, double newMarks);
    void deleteStudent(int id);
}

// Base class (Inheritance)
class Person {
    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Student class (Inheritance + Encapsulation + Polymorphism)
class Student extends Person {
    private String course;
    private double marks;

    Student(int id, String name, String course, double marks) {
        super(id, name);
        this.course = course;
        this.marks = marks;
    }

    // Encapsulation (Getters and Setters)
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    // Overriding (Polymorphism)
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Course: " + course + ", Marks: " + marks +
                ", Result: " + (marks >= 40 ? "PASS" : "FAIL"));
    }

    // Overloading (Polymorphism)
    public void displayInfo(boolean showOnlyName) {
        if (showOnlyName) {
            System.out.println("Student Name: " + name);
        } else {
            displayInfo();
        }
    }
}

// Teacher class (More Inheritance example)
class Teacher extends Person {
    private String subject;

    Teacher(int id, String name, String subject) {
        super(id, name);
        this.subject = subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}

// Student Database using HashMap (Abstraction in action)
class StudentDatabase implements DatabaseOperations {
    private final Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.id, student);  // Overwrites if ID already exists
        System.out.println("Student Added Successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println(" No students found.");
        } else {
            System.out.println("All Students:");
            for (Student s : students.values()) {
                s.displayInfo();
                System.out.println("----------------");
            }
        }
    }

    public void updateStudent(int id, String newCourse, double newMarks) {
        Student student = students.get(id);
        if (student != null) {
            student.setCourse(newCourse);
            student.setMarks(newMarks);
            System.out.println(" Student Updated.");
        } else {
            System.out.println(" Student not found.");
        }
    }

    public void deleteStudent(int id) {
        if (students.remove(id) != null) {
            System.out.println(" Student Deleted.");
        } else {
            System.out.println("⚠ Student not found.");
        }
    }
}

// Main class (Driver code)
public class StudentProjectMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDatabase db = new StudentDatabase();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();
                    db.addStudent(new Student(id, name, course, marks));
                }
                case 2 -> db.viewStudents();
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter New Marks: ");
                    double marks = sc.nextDouble();
                    db.updateStudent(id, course, marks);
                }
                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    db.deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
