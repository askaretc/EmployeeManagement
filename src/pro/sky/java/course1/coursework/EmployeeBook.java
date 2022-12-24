package pro.sky.java.course1.coursework;

/**
 * EmployeeBook is a "utility-class" for working with Employee's class objects.
 * The class contains a private final Employee[] array and methods for working with this array elements.
 *
 * @author Askar Gizatullin
 * @version 1.0
 */
public class EmployeeBook {
    private final Employee[] employees;


    /**
     * Class constructor specifying number of array elements.
     *
     * @param employeesAmount - the number of employees that the array should contain.
     */
    public EmployeeBook(int employeesAmount) {
        employees = new Employee[employeesAmount];
    }


    public void addEmployee(String fullName, int department, int salary) {
        Employee employee = new Employee(fullName, department, salary);
        employees[getIndexOfFreeElement()] = employee;
        System.out.println("The employee(id=" + employee.getId() + ") has been added.");
    }

    private int getIndexOfFreeElement() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        throw new RuntimeException("The array is full.");
    }

    public void removeEmployee(int employeesId) {
        if (checkAllElementsIsNotNull()) {
            if (validateIdArgument(employeesId)) {
                for (int i = 0; i < employees.length; i++) {
                    if (employees[i] != null && employees[i].getId() == employeesId) {
                        System.out.println("The employee(id=" + employees[i].getId() + ") has been removed.");
                        employees[i] = null;
                        return;
                    }
                }
            }
        }
    }

    private boolean validateIdArgument(int id) {
        boolean found = false;
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == id) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("The employee with this id was not found.");
        }
        return true;
    }

    public void editEmployeesSalary(int employeesId, int newEmployeesSalary) {
        if (checkAllElementsIsNotNull()) {
            if (validateIdArgument(employeesId)) {
                for (Employee employee : employees) {
                    if (employee != null && employee.getId() == employeesId) {
                        employee.setSalary(newEmployeesSalary);
                    }
                }
            }
        }
    }

    public void editEmployeesDepartment(int employeesId, int newEmployeesDepartment) {
        if (checkAllElementsIsNotNull()) {
            if (validateIdArgument(employeesId)) {
                for (Employee employee : employees) {
                    if (employee != null && employee.getId() == employeesId) {
                        employee.setDepartment(newEmployeesDepartment);
                    }
                }
            }
        }
    }

    public void printAllEmployeesFullNameAccordingToDepartment() {
        StringBuilder sb = new StringBuilder();
        if (checkAllElementsIsNotNull()) {
            int maxDepartment = 0;
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() > maxDepartment) {
                    maxDepartment = employee.getDepartment();
                }
            }
            for (int i = 1; i <= maxDepartment; i++) {
                sb.append("Department ").append(i).append(":\n");
                for (Employee employee : employees) {
                    if (employee != null && employee.getDepartment() == i) {
                        String s = employee.getFullName();
                        sb.append(s).append("\n");
                    }
                }
            }

        }
        String result = sb.toString();
        System.out.print(result);
    }

    public void printAllEmployeesInformation() {
        if (checkAllElementsIsNotNull()) {
            System.out.println("All employees: ");
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        }
    }

    private boolean checkAllElementsIsNotNull() {
        int j = 0;
        for (Object object : employees) {
            if (object == null) {
                j++;
            }
        }
        if (j == employees.length) {
            throw new RuntimeException("The array is empty.");
        }
        return true;
    }

    public void printTotalSalary() {
        if (checkAllElementsIsNotNull()) {
            System.out.println("The total amount of all salaries: " + calculateTotalSalary());
        }
    }

    private int calculateTotalSalary() {
        int totalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    totalSalary += employee.getSalary();
                }
            }
        }
        return totalSalary;
    }

    public void printEmployeeWithMaximalSalary() {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getSalary() == calculateMaximalSalary()) {
                        System.out.println("Employee with maximal salary: " + employee);
                    }
                }
            }
        }
    }

    private int calculateMaximalSalary() {
        int maximalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getSalary() > maximalSalary) {
                        maximalSalary = employee.getSalary();
                    }
                }
            }
        }
        return maximalSalary;
    }

    public void printEmployeeWithMinimalSalary() {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getSalary() == calculateMinimalSalary()) {
                        System.out.println("Employee with minimal salary: " + employee);
                    }
                }
            }
        }
    }

    private int calculateMinimalSalary() {
        int minimalSalary = Integer.MAX_VALUE;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    if (employee.getSalary() < minimalSalary) {
                        minimalSalary = employee.getSalary();
                    }
                }
            }
        }
        return minimalSalary;
    }

    public void printAverageSalary() {
        if (checkAllElementsIsNotNull()) {
            System.out.printf("The average salary: %.2f\n", calculateAverageSalary());
        }
    }

    private double calculateAverageSalary() {
        double averageSalary;
        int i = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    i++;
                }
            }
        }
        averageSalary = (double) calculateTotalSalary() / i;
        return averageSalary;
    }

    public void printAllEmployeesFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append("Full name of all employees: " + "\n");
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    String s = employee.getFullName();
                    sb.append(s).append("\n");
                }
            }
        }
        String result = sb.toString();
        System.out.print(result);
    }

    public void indexAllEmployeesSalary(double percent) {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null) {
                    double newSalaryUoToCents = (double) employee.getSalary() * (1 + percent / 100);
                    int newSalaryWithoutCents = (int) newSalaryUoToCents;
                    employee.setSalary(newSalaryWithoutCents);
                }
            }
        }
    }

    public void printEmployeeWithMaximalSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (employee.getSalary() == calculateMaximalSalaryByDepartment(department)) {
                        System.out.println("Employee with maximal salary from the " + department + " department: " + employee);
                    }
                }
            }
        }
    }

    private int calculateMaximalSalaryByDepartment(int department) {
        int maximalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (employee.getSalary() > maximalSalary) {
                        maximalSalary = employee.getSalary();
                    }
                }
            }
        }
        return maximalSalary;
    }

    public void printEmployeeWithMinimalSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (employee.getSalary() == calculateMinimalSalaryByDepartment(department)) {
                        System.out.println("Employee with minimal salary from the " + department + " department: " + employee);
                    }
                }
            }
        }
    }

    private int calculateMinimalSalaryByDepartment(int department) {
        int minimalSalary = Integer.MAX_VALUE;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (employee.getSalary() < minimalSalary) {
                        minimalSalary = employee.getSalary();
                    }
                }
            }
        }
        return minimalSalary;
    }

    public void printTotalSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("The total amount of all salaries for " + department + " department: " + calculateTotalSalaryByDepartment(department));
        }
    }

    private int calculateTotalSalaryByDepartment(int department) {
        int totalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    totalSalary += employee.getSalary();
                }
            }
        }
        return totalSalary;
    }

    public void printAverageSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.printf("The average salary for %d department: %.2f\n", department, calculateAverageSalaryByDepartment(department));
        }
    }

    private double calculateAverageSalaryByDepartment(int department) {
        double averageSalary;
        int i = 0;
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    i++;
                }
            }
        }
        averageSalary = (double) calculateTotalSalaryByDepartment(department) / i;
        return averageSalary;
    }

    public void indexAllEmployeesSalaryByDepartment(int department, double percent) {
        if (checkAllElementsIsNotNull()) {
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    double newSalaryUoToCents = (double) employee.getSalary() * (1 + percent / 100);
                    int newSalaryWithoutCents = (int) newSalaryUoToCents;
                    employee.setSalary(newSalaryWithoutCents);
                }
            }
        }
    }

    public void printAllEmployeesInformationByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("All employees from the " + department + " department: ");
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    System.out.println("id = " + employee.getId() + ", full name = " + employee.getFullName() + ", salary = " + employee.getSalary());
                }
            }
        }
    }

    public void printEmployeesWithSalaryLessThanNumber(int number) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("Employees with a salary less than " + number + ": ");
            int j = 0;
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < number) {
                    System.out.println("id = " + employee.getId() + ", full name = " + employee.getFullName() + ", salary = " + employee.getSalary());
                    j++;
                }
            }
            if (j == 0) {
                System.out.println("Not Found");
            }
        }
    }

    public void printEmployeesWithSalaryGreaterThanNumber(int number) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("Employees with a salary greater than(or equal to) " + number + ": ");
            int j = 0;
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() >= number) {
                    System.out.println("id = " + employee.getId() + ", full name = " + employee.getFullName() + ", salary = " + employee.getSalary());
                    j++;
                }
            }
            if (j == 0) {
                System.out.println("Not Found");
            }
        }
    }
}