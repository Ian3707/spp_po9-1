import java.util.ArrayList;
import java.util.List;


interface SalaryCalculationStrategy {
    double calculateSalary(Employee1 employee);
}


class StandardSalaryStrategy implements SalaryCalculationStrategy {
    @Override
    public double calculateSalary(Employee1 employee) {
        return employee.getBaseSalary();
    }
}

class HourlySalaryStrategy implements SalaryCalculationStrategy {
    private double hourlyRate;

    public HourlySalaryStrategy(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(Employee1 employee) {
        return hourlyRate * employee.getHoursWorked();
    }
}

class SalaryCalculator {
    private SalaryCalculationStrategy calculationStrategy;

    public SalaryCalculator(SalaryCalculationStrategy calculationStrategy) {
        this.calculationStrategy = calculationStrategy;
    }

    public double calculate(Employee1 employee) {
        return calculationStrategy.calculateSalary(employee);
    }
}

class Employee1 {
    private String name;
    private double baseSalary;
    private double hoursWorked;

    public Employee1(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

class Department {
    private String name;
    private List<Employee1> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee1 employee) {
        employees.add(employee);
    }

    public List<Employee1> getEmployees() {
        return employees;
    }

}

public class task3 {
    public static void main(String[] args) {
        Department development = new Department("Development");
        Department marketing = new Department("Marketing");

        development.addEmployee(new Employee1("John", 5000));
        development.addEmployee(new Employee1("Alice", 6000));
        marketing.addEmployee(new Employee1("Bob", 4500));

        SalaryCalculationStrategy standardStrategy = new StandardSalaryStrategy();
        SalaryCalculationStrategy hourlyStrategy = new HourlySalaryStrategy(20);

        SalaryCalculator standardCalculator = new SalaryCalculator(standardStrategy);
        SalaryCalculator hourlyCalculator = new SalaryCalculator(hourlyStrategy);

        System.out.println("Salary Report:");
        System.out.println("-------------");

        System.out.println("Development Department:");
        for (Employee1 employee : development.getEmployees()) {
            System.out.println(employee.getName() + ": $" + standardCalculator.calculate(employee));
        }

        System.out.println("\nMarketing Department:");
        for (Employee1 employee : marketing.getEmployees()) {
            employee.setHoursWorked(160);
            System.out.println(employee.getName() + ": $" + hourlyCalculator.calculate(employee));
        }
    }
}
