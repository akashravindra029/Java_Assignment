import java.sql.*;
import java.util.Scanner;

public class Student_Management {

    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "2001";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student Record");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Record");
            System.out.println("4. Delete Student Record");
            System.out.println("5. Search Student Record");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> viewStudents();
                case 3 -> updateStudent(sc);
                case 4 -> deleteStudent(sc);
                case 5 -> searchStudent(sc);
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private static void addStudent(Scanner sc) {
        try (Connection conn = connect()) {
            String sql = "INSERT INTO students (id, name, age, course, email, contact) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());
            sc.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            ps.setString(2, sc.nextLine());

            System.out.print("Enter Age: ");
            ps.setInt(3, sc.nextInt());
            sc.nextLine();

            System.out.print("Enter Course: ");
            ps.setString(4, sc.nextLine());

            System.out.print("Enter Email: ");
            ps.setString(5, sc.nextLine());

            System.out.print("Enter Contact Number: ");
            ps.setString(6, sc.nextLine());

            ps.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudents() {
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d | Course: %s | Email: %s | Contact: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("course"), rs.getString("email"), rs.getString("contact"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateStudent(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Enter Student ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter new Course: ");
            String course = sc.nextLine();

            System.out.print("Enter new Contact Number: ");
            String contact = sc.nextLine();

            String sql = "UPDATE students SET course = ?, contact = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course);
            ps.setString(2, contact);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("Student ID not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student ID not found.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudent(Scanner sc) {
        try (Connection conn = connect()) {
            System.out.print("Search by (1) ID or (2) Name? ");
            int opt = sc.nextInt();
            sc.nextLine();

            String sql;
            PreparedStatement ps;

            if (opt == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sql = "SELECT * FROM students WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
            } else {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                sql = "SELECT * FROM students WHERE name LIKE ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Age: %d | Course: %s | Email: %s | Contact: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("course"), rs.getString("email"), rs.getString("contact"));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
