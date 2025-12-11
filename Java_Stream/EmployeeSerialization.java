import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(1, "Shubham", "IT", 45000));
        list.add(new Employee(2, "Aman", "HR", 38000));
        list.add(new Employee(3, "Priya", "Finance", 52000));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
            oos.writeObject(list);
            oos.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"));
            ArrayList<Employee> data = (ArrayList<Employee>) ois.readObject();
            ois.close();

            for (Employee e : data) {
                System.out.println(e.id + " " + e.name + " " + e.department + " " + e.salary);
            }
        } 
        catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
