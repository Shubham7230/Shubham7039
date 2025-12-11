import java.util.*;

class Employee {
    String name;
    String department;
    
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class EmployeeGrouper {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> result = new HashMap<>();
        
        for (Employee employee : employees) {
            String dept = employee.department;
            if (!result.containsKey(dept)) {
                result.put(dept, new ArrayList<>());
            }
            result.get(dept).add(employee);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );
        
        Map<String, List<Employee>> grouped = groupByDepartment(employees);
        System.out.println(grouped);
    }
}