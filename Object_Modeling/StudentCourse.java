import java.util.*;

class Course {
    String name;
    List<Student> students = new ArrayList<>();

    Course(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course c) {
        courses.add(c);
        c.addStudent(this);
    }

    void showCourses() {
        for (Course c : courses) {
            System.out.println(c.name);
        }
    }
}

class School {
    String name;
    List<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        for (Student s : students) {
            System.out.println(s.name);
        }
    }
}

public class StudentCourse{
    public static void main(String[] args) {
        School school = new School("Central School");

        Student s1 = new Student("Rahul");
        Student s2 = new Student("Asha");

        Course c1 = new Course("Math");
        Course c2 = new Course("Science");

        school.addStudent(s1);
        school.addStudent(s2);

        s1.enroll(c1);
        s1.enroll(c2);
        s2.enroll(c1);

        System.out.println("Rahul Courses:");
        s1.showCourses();

        System.out.println("Asha Courses:");
        s2.showCourses();

        System.out.println("Math Students:");
        c1.showStudents();

        System.out.println("Science Students:");
        c2.showStudents();
    }
}
