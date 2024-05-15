import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Employee {
    private String name;
    private String department;
    private double salary;
    private int yearsOfExperience;

    public Employee(String name, String department, double salary, int yearsOfExperience) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public void sortEmployeesByExperience() {
        Collections.sort(employees, Comparator.comparingInt(Employee::getYearsOfExperience).reversed());
    }
}

class EmployeeIterator implements Iterator<Employee> {
    private List<Employee> employees;
    private int position = 0;

    public EmployeeIterator(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean hasNext() {
        return position < employees.size();
    }

    @Override
    public Employee next() {
        return employees.get(position++);
    }
}

class SalaryReport {
    private List<Department> departments;

    public SalaryReport() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void generateReport() {
        for (Department department : departments) {
            System.out.println("Department: " + department.getName());
            department.sortEmployeesByExperience();
            EmployeeIterator iterator = new EmployeeIterator(department.getEmployees());

            while (iterator.hasNext()) {
                Employee employee = iterator.next();
                System.out.println(employee);
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Department devDepartment = new Department("Development");
        Department hrDepartment = new Department("Human Resources");

        devDepartment.addEmployee(new Employee("Alice", "Development", 70000, 5));
        devDepartment.addEmployee(new Employee("Bob", "Development", 60000, 3));
        devDepartment.addEmployee(new Employee("Charlie", "Development", 80000, 7));

        hrDepartment.addEmployee(new Employee("David", "Human Resources", 50000, 4));
        hrDepartment.addEmployee(new Employee("Eve", "Human Resources", 45000, 2));

        SalaryReport report = new SalaryReport();
        report.addDepartment(devDepartment);
        report.addDepartment(hrDepartment);

        report.generateReport();
    }
}

