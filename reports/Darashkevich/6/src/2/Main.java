import java.util.ArrayList;
import java.util.List;


class Employee {
    private String name;
    private String department;
    private String position;
    private double salary;
    private List<Employee> subordinates;

    public Employee(String name, String department, String position, double salary) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(Employee employee) {
        subordinates.add(employee);
    }

    public void removeSubordinate(Employee employee) {
        subordinates.remove(employee);
    }

    public void printEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("Subordinates:");
        for (Employee subordinate : subordinates) {
            subordinate.printEmployee();
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Employee ceo = new Employee("John Doe", "Management", "CEO", 10000);
        Employee manager1 = new Employee("Alice Smith", "Management", "Manager", 7000);
        Employee manager2 = new Employee("Bob Johnson", "Management", "Manager", 7000);
        Employee developer1 = new Employee("Charlie Brown", "Engineering", "Developer", 5000);
        Employee developer2 = new Employee("David Miller", "Engineering", "Developer", 5000);


        ceo.addSubordinate(manager1);
        ceo.addSubordinate(manager2);
        manager1.addSubordinate(developer1);
        manager2.addSubordinate(developer2);


        System.out.println("Company Structure:");
        ceo.printEmployee();
    }
}