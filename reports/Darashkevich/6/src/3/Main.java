import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Visitor {
    void visit(Employee employee);
}

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

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Employee subordinate : subordinates) {
            subordinate.accept(visitor);
        }
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

class SalaryCalculator implements Visitor {
    private Map<String, Double> departmentSalaries;

    public SalaryCalculator() {
        this.departmentSalaries = new HashMap<>();
    }

    @Override
    public void visit(Employee employee) {
        String department = employee.getDepartment();
        double salary = employee.getSalary();
        departmentSalaries.put(department, departmentSalaries.getOrDefault(department, 0.0) + salary);
    }

    public void printReport() {
        System.out.println("Salary Report:");
        for (Map.Entry<String, Double> entry : departmentSalaries.entrySet()) {
            System.out.println("Department: " + entry.getKey() + ", Total Salary: " + entry.getValue());
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

        SalaryCalculator calculator = new SalaryCalculator();

        ceo.accept(calculator);

        calculator.printReport();
    }
}
