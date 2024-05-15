import java.util.ArrayList;
import java.util.List;

interface EmployeeComponent {
    void add(EmployeeComponent employee);
    void remove(EmployeeComponent employee);
    List<EmployeeComponent> getSubordinates();
    String getInfo();
}

class Employee implements EmployeeComponent {
    private String name;
    private String department;
    private String position;
    private double salary;

    public Employee(String name, String department, String position, double salary) {
        this.name = name;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    public void add(EmployeeComponent employee) {
    }

    public void remove(EmployeeComponent employee) {
    }

    public List<EmployeeComponent> getSubordinates() {
        return new ArrayList<>();
    }

    public String getInfo() {
        return "Name: " + name + ", Department: " + department + ", Position: " + position + ", Salary: " + salary;
    }
}

// Композит
class Manager implements EmployeeComponent {
    private String name;
    private List<EmployeeComponent> subordinates;

    public Manager(String name) {
        this.name = name;
        this.subordinates = new ArrayList<>();
    }

    public void add(EmployeeComponent employee) {
        subordinates.add(employee);
    }

    public void remove(EmployeeComponent employee) {
        subordinates.remove(employee);
    }

    public List<EmployeeComponent> getSubordinates() {
        return subordinates;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder("Manager: " + name + "\n");
        for (EmployeeComponent employee : subordinates) {
            info.append(employee.getInfo()).append("\n");
        }
        return info.toString();
    }
}

public class task2 {
    public static void main(String[] args) {
        EmployeeComponent ceo = new Manager("John (CEO)");
        EmployeeComponent manager1 = new Manager("Alice (Manager)");
        EmployeeComponent manager2 = new Manager("Bob (Manager)");
        EmployeeComponent employee1 = new Employee("Tom", "Sales", "Salesman", 5000);
        EmployeeComponent employee2 = new Employee("Jerry", "IT", "Developer", 6000);

        manager1.add(employee1);
        manager2.add(employee2);
        ceo.add(manager1);
        ceo.add(manager2);

        System.out.println(ceo.getInfo());
    }
}
