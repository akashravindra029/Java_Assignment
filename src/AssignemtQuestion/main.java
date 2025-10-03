package AssignemtQuestion;


final class Employee {
    private final int id;
    private final String name;
    private final double salary;

    // Constructor to initialize all fields
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getter methods to access fields (no setters)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Optional: override toString() for easy printing
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

// Testing the immutable class
public class main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Akash", 50000);

        System.out.println(emp1);

        // emp1.setSalary(60000); // ❌ Not allowed, no setter exists

        System.out.println("ID: " + emp1.getId());
        System.out.println("Name: " + emp1.getName());
        System.out.println("Salary: " + emp1.getSalary());
    }
}
