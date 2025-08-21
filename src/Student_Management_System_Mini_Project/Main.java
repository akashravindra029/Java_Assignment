package Student_Management_System_Mini_Project;

 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDatabase db = new StudentDatabase();

        while (true) {
            System.out.println(" Student Database System");
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
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    Student student = new Student(id, name, age, course, marks);
                    db.addStudent(student);
                }

                case 2 -> db.viewStudents();

                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course is: ");
                    String course = sc.nextLine();
                    System.out.print("New Marks is: ");
                    double marks = sc.nextDouble();
                    db.updateStudent(id, course, marks);
                }

                case 4 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();
                    db.deleteStudent(id);
                }

                case 5 -> {
                    System.out.println(" Exit.");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}

