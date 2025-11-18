import java.util.*;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

class Department {
    String deptName;
    ArrayList<Employee> employees = new ArrayList<>();

    Department(String deptName) {
        this.deptName = deptName;
    }

    void addEmployee(Employee e) {
        employees.add(e);
    }

    void showEmployees() {
        for (Employee e : employees) {
            e.display();
        }
    }
}

class Company {
    String companyName;
    ArrayList<Department> depts = new ArrayList<>();

    Company(String companyName) {
        this.companyName = companyName;
    }

    void addDepartment(Department d) {
        depts.add(d);
    }

    void showCompanyStructure() {
        for (Department d : depts) {
            System.out.println("Department: " + d.deptName);
            d.showEmployees();
        }
    }
}

public class EmployeeCompositionMain {
    public static void main(String[] args) {
        Company c = new Company("TechSoft Pvt Ltd");

        Department d1 = new Department("HR");
        Department d2 = new Department("IT");

        d1.addEmployee(new Employee("Shubham"));
        d1.addEmployee(new Employee("Aman"));

        d2.addEmployee(new Employee("Ravi"));
        d2.addEmployee(new Employee("Neha"));

        c.addDepartment(d1);
        c.addDepartment(d2);

        c.showCompanyStructure();
    }
}
