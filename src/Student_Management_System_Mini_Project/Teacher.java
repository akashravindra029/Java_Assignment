package Student_Management_System_Mini_Project;


    public class Teacher extends Person {
        private String subject;

        public Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        @Override
        public void displayInfo() {
            System.out.println("Teacher: " + name + ", Subject: " + subject);
        }
    }


