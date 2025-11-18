import java.util.*;

class Professor {
    String name;
    List<Course> courses = new ArrayList<>();

    Professor(String name) {
        this.name = name;
    }

    void assignCourse(Course c) {
        courses.add(c);
        c.setProfessor(this);
        System.out.println(name + " assigned to " + c.title);
    }

    void showCourses() {
        for (Course c : courses) System.out.println(c.title);
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course c) {
        courses.add(c);
        c.addStudent(this);
        System.out.println(name + " enrolled in " + c.title);
    }

    void showCourses() {
        for (Course c : courses) System.out.println(c.title);
    }
}

class Course {
    String title;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String title) {
        this.title = title;
    }

    void setProfessor(Professor p) {
        professor = p;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    void showStudents() {
        for (Student s : students) System.out.println(s.name);
    }

    void showProfessor() {
        if (professor != null) System.out.println(professor.name);
    }
}

public class UniversityManagement{
    public static void main(String[] args) {
        Student s1 = new Student("Ravi");
        Student s2 = new Student("Neha");

        Professor p1 = new Professor("Dr. Singh");
        Professor p2 = new Professor("Dr. Mehta");

        Course c1 = new Course("Data Structures");
        Course c2 = new Course("Operating Systems");

        p1.assignCourse(c1);
        p2.assignCourse(c2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s1.enrollCourse(c2);

        System.out.println("Students in Data Structures:");
        c1.showStudents();

        System.out.println("Professor for OS:");
        c2.showProfessor();

        System.out.println("Ravi Courses:");
        s1.showCourses();

        System.out.println("Courses taught by Dr. Singh:");
        p1.showCourses();
    }
}
