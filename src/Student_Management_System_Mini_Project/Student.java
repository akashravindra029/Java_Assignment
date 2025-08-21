package Student_Management_System_Mini_Project;


    public class Student extends Person {
        private int id;
        private String course;
        private double marks;

        public Student(int id, String name, int age, String course, double marks) {
            super(name, age);
            this.id = id;
            this.course = course;
            this.marks = marks;
        }

        public int getId() {
            return id;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public void setMarks(double marks) {
            this.marks = marks;
        }

        @Override
        public void displayInfo() {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age +
                    ", Course: " + course + ", Marks: " + marks);
        }

        public void displayInfo(boolean brief) {
            if (brief) {
                System.out.println(id + " - " + name);
            } else {
                displayInfo();
            }
        }
    }


