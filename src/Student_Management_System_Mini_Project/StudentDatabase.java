package Student_Management_System_Mini_Project;


import java.util.ArrayList;
import java.util.List;

    public class StudentDatabase implements DatabaseOperations {
        

        private List<Student> StudentList = new ArrayList<>();

        @Override
        public void addStudent(Student student) {
            StudentList.add(student);
            System.out.println(" Student added successfully.");
        }

        @Override
        public void updateStudent(int id, String newCourse, double newMarks) {
            for (Student s : StudentList) {
                if (s.getId() == id) {
                    s.setCourse(newCourse);
                    s.setMarks(newMarks);
                    System.out.println(" Student updated successfully.");
                    return;
                }
            }
            System.out.println(" Student with ID " + id + " not found.");
        }

        @Override
        public void deleteStudent(int id) {
            boolean removed = StudentList.removeIf(s -> s.getId() == id);
            if (removed) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println(" Student with ID " + id + " not found.");
            }
        }

        @Override
        public void viewStudents() {
            if (StudentList.isEmpty()) {
                System.out.println(" No student records found.");
            } else {
                System.out.println(" All Students:");
                for (Student s : StudentList) {
                    s.displayInfo();
                }
            }
        }
    }


