import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private static class Student {
        private String name;
        private int rollNumber;
        private String grade;
        

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

       
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    private static class ManagementSystem {
        private List<Student> studentList;

        public ManagementSystem() {
            studentList = new ArrayList<>();
        }

        public void addStudent(Student student) {
            studentList.add(student);
        }

        public void removeStudent(int rollNumber) {
            Student foundStudent = findByRollNumber(rollNumber);
            if (foundStudent != null) {
                studentList.remove(foundStudent);
            }
        }

        public Student findByRollNumber(int rollNumber) {
            for (Student student : studentList) {
                if (student.getRollNumber() == rollNumber) {
                    return student;
                }
            }
            return null;
        }

        public void displayStudents() {
            if (studentList.isEmpty()) {
                System.out.println("Sorry no students in the system.");
            } else {
                System.out.println(" This is Student List:");
                for (Student student : studentList) {
                    System.out.println("Name: " + student.getName() +
                                       ", Roll Number: " + student.getRollNumber() +
                                       ", Grade: " + student.getGrade());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagementSystem s = new ManagementSystem();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== The Student Management System ===");
            System.out.println("\n1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.println("Please enter your choice: ");
            int c = sc.nextInt();
            sc.nextLine(); 

            switch (c) {
                case 1:
                    addStudent(sc, s);
                    break;
                case 2:
                    removeStudent(sc, s);
                    break;
                case 3:
                    searchStudent(sc, s);
                    break;
                case 4:
                    displayStudents(s);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Its Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
        System.out.println("Thanks for using the Student Management System. Have a nice day!");
    }

    private static void addStudent(Scanner sc, ManagementSystem s) {
        System.out.println("Enter student name: ");
        String name = sc.nextLine();

        System.out.println("Enter student roll number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter student grade: ");
        String grade = sc.nextLine();

        Student student = new Student(name, rollNumber, grade);
        s.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent(Scanner sc, ManagementSystem s) {
        System.out.println("Enter roll number of the student to remove: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); 
        s.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent(Scanner sc, ManagementSystem s) {
        System.out.println("Enter roll number of the student to search: ");
        int rollNumber = sc.nextInt();
        sc.nextLine(); 

        Student foundStudent = s.findByRollNumber(rollNumber);
        if (foundStudent != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + foundStudent.getName() +
                               ", Roll Number: " + foundStudent.getRollNumber() +
                               ", Grade: " + foundStudent.getGrade());
        } else {
            System.out.println("Student not found, Check once.");
        }
    }

    private static void displayStudents(ManagementSystem s) {
        s.displayStudents();
    }
}