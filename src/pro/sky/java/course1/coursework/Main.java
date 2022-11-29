package pro.sky.java.course1.coursework;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        ////////// EASY LEVEL //////////
        Employee employee1 = new Employee("Jon Snow", 1, 70_000);
        Employee employee2 = new Employee("Rob Stark", 1, 64_000);
        Employee employee3 = new Employee("Sansa Stark", 2, 45_000);
        Employee employee4 = new Employee("Arya Stark", 2, 50_000);
        Employee employee5 = new Employee("Jaime Lannister", 3, 59_000);
        Employee employee6 = new Employee("Tyrion Lannister", 4, 65_000);
        Employee employee7 = new Employee("Daenerys Targaryen", 5, 88_088);
        addEmployee(employee1);
        addEmployee(employee2);
        addEmployee(employee3);
        addEmployee(employee4);
        addEmployee(employee5);
        addEmployee(employee6);
        addEmployee(employee7);
        printAllEmployeesInformation();
        System.out.println("=========================================================================================");
        printEmployeeWithMaximalSalary();
        printEmployeeWithMinimalSalary();
        printTotalSalary();
        printAverageSalary();
        System.out.println("=========================================================================================");
        printAllEmployeesFullName();
        System.out.println("=========================================================================================");
        System.out.println("=========================================================================================");


        ////////// MEDIUM LEVEL //////////
        indexAllEmployeesSalary(5.55);
        printAllEmployeesInformation();
        System.out.println("=========================================================================================");
        printEmployeeWithMaximalSalaryByDepartment(1);
        printEmployeeWithMinimalSalaryByDepartment(1);
        printTotalSalaryByDepartment(1);
        printAverageSalaryByDepartment(1);
        indexAllEmployeesSalaryByDepartment(1, 4.49);
        printAllEmployeesInformationByDepartment(1);
        System.out.println("=========================================================================================");
        printEmployeesWithSalaryLessThanNumber(65_000);
        printEmployeesWithSalaryGreaterThanNumber(65_000);
    }


    ////////// EASY LEVEL //////////
    public static void addEmployee(Employee employee) {
        employees[getIndexOfFreeElement()] = employee;
    }

    private static int getIndexOfFreeElement() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        throw new RuntimeException("The array is full.");
    }

    public static void printAllEmployeesInformation() {
        if (checkAllElementsIsNotNull()) {
            System.out.println("All employees: ");
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee);
                }
            }
        }
    }

    private static boolean checkAllElementsIsNotNull() {
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

    public static void printTotalSalary() {
        if (checkAllElementsIsNotNull()) {
            System.out.println("The total amount of all salaries: " + calculateTotalSalary());
        }
    }

    private static int calculateTotalSalary() {
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

    public static void printEmployeeWithMaximalSalary() {
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

    private static int calculateMaximalSalary() {
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

    public static void printEmployeeWithMinimalSalary() {
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

    private static int calculateMinimalSalary() {
        int minimalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (int i = 0; i < employees.length; i++) {
                if (i == 0) {
                    minimalSalary = employees[i].getSalary();
                }
                if (employees[i] != null) {
                    if (employees[i].getSalary() < minimalSalary) {
                        minimalSalary = employees[i].getSalary();
                    }
                }
            }
        }
        return minimalSalary;
    }

    public static void printAverageSalary() {
        if (checkAllElementsIsNotNull()) {
            System.out.printf("The average salary: %.2f\n", calculateAverageSalary());
        }
    }

    private static double calculateAverageSalary() {
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

    public static void printAllEmployeesFullName() {
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


    ////////// MEDIUM LEVEL //////////
    public static void indexAllEmployeesSalary(double percent) {
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

    public static void printEmployeeWithMaximalSalaryByDepartment(int department) {
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

    private static int calculateMaximalSalaryByDepartment(int department) {
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

    public static void printEmployeeWithMinimalSalaryByDepartment(int department) {
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

    private static int calculateMinimalSalaryByDepartment(int department) {
        int minimalSalary = 0;
        if (checkAllElementsIsNotNull()) {
            for (int i = 0; i < employees.length; i++) {
                if (i == 0) {
                    minimalSalary = employees[i].getSalary();
                }
                if (employees[i] != null && employees[i].getDepartment() == department) {
                    if (employees[i].getSalary() < minimalSalary) {
                        minimalSalary = employees[i].getSalary();
                    }
                }
            }
        }
        return minimalSalary;
    }

    public static void printTotalSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("The total amount of all salaries for " + department + " department: " + calculateTotalSalaryByDepartment(department));
        }
    }

    private static int calculateTotalSalaryByDepartment(int department) {
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

    public static void printAverageSalaryByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.printf("The average salary for %d department: %.2f\n", department, calculateAverageSalaryByDepartment(department));
        }
    }

    private static double calculateAverageSalaryByDepartment(int department) {
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

    public static void indexAllEmployeesSalaryByDepartment(int department, double percent) {
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

    public static void printAllEmployeesInformationByDepartment(int department) {
        if (checkAllElementsIsNotNull()) {
            System.out.println("All employees from the " + department + " department: ");
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    System.out.println("id = " + employee.getId() + ", full name = " + employee.getFullName() + ", salary = " + employee.getSalary());
                }
            }
        }
    }

    public static void printEmployeesWithSalaryLessThanNumber(int number) {
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

    public static void printEmployeesWithSalaryGreaterThanNumber(int number) {
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