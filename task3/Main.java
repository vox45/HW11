import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + ", department='" + department + "'}";
    }
}

class Company {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee '" + employee.getName() + "' added to the company.");
    }

    public void removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            System.out.println("Employee '" + employee.getName() + "' removed from the company.");
        } else {
            System.out.println("Employee not found in the company.");
        }
    }

    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public double calculateAverageSalary() {
        if (employees.isEmpty()) {
            return 0;
        } else {
            return calculateTotalSalary() / employees.size();
        }
    }

    public void displayEmployeeList() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Створення компанії
        Company company = new Company();

        // Додавання працівників
        Employee manager = new Employee("John Manager", 5000, "Management");
        Employee engineer = new Employee("Alice Engineer", 4000, "Engineering");
        company.addEmployee(manager);
        company.addEmployee(engineer);

        // Виведення інформації про працівників
        company.displayEmployeeList();

        // Видалення працівника
        company.removeEmployee(manager);

        // Виведення інформації про працівників після видалення
        company.displayEmployeeList();

        // Підрахунок та виведення загальної та середньої зарплати
        double totalSalary = company.calculateTotalSalary();
        double averageSalary = company.calculateAverageSalary();
        System.out.println("Total Salary: " + totalSalary);
        System.out.println("Average Salary: " + averageSalary);
    }
}
