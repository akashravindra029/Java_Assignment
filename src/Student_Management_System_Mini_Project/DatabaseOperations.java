package Student_Management_System_Mini_Project;

public interface DatabaseOperations {
    void addStudent(Student student);
    void updateStudent(int id, String newCourse, double newMarks);
    void deleteStudent(int id);
    void viewStudents();
}
