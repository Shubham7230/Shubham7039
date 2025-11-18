import java.util.*;

class Department {
    String name;
    Department(String name) {
        this.name = name;
    }
}

class Faculty {
    String name;
    Faculty(String name) {
        this.name = name;
    }
}

class University {
    String name;
    List<Department> departments = new ArrayList<>();
    List<Faculty> facultyList = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(Department d) {
        departments.add(d);
    }

    void addFaculty(Faculty f) {
        facultyList.add(f);
    }

    void showDepartments() {
        for (Department d : departments) System.out.println(d.name);
    }

    void showFaculty() {
        for (Faculty f : facultyList) System.out.println(f.name);
    }

    void deleteUniversity() {
        departments.clear();
        facultyList.clear();
        System.out.println("University deleted");
    }
}

public class UniversityMain{
    public static void main(String[] args) {
        University u = new University("ABC University");

        Department d1 = new Department("Computer Science");
        Department d2 = new Department("Mechanical");

        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Gupta");

        u.addDepartment(d1);
        u.addDepartment(d2);

        u.addFaculty(f1);
        u.addFaculty(f2);

        System.out.println("Departments:");
        u.showDepartments();

        System.out.println("Faculty:");
        u.showFaculty();

        u.deleteUniversity();

        System.out.println("After Deletion:");
        u.showDepartments();
        u.showFaculty();
    }
}
