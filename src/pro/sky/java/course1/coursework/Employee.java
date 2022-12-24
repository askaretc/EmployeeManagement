package pro.sky.java.course1.coursework;

import java.util.Objects;

/**
 * Employee is a "warehouse-class" that aggregating the employee's ID, full name, department and salary.
 * The class includes only properties and state.
 *
 * @author Askar Gizatullin
 * @version 1.0
 */
public class Employee {

    private static int idCounter = 1;
    private final int id;
    private final String fullName;
    private int department;
    private int salary;


    /**
     * Class constructor that creates an employee.
     *
     * @param fullName - full name of the employee.
     * @param department - the employee's department number in the range of [1-5].
     * @param salary - employee's salary in monetary units.
     * @throws IllegalArgumentException if method has been passed an illegal or inappropriate argument.
     */
    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        if (validateDepartmentArgument(department)) {
            this.department = department;
        }
        if (validateSalaryArgument(salary)) {
            this.salary = salary;
        }
        id = idCounter++;
    }


    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        if (validateDepartmentArgument(department)) {
            this.department = department;
        }
    }

    public void setSalary(int salary) {
        if (validateSalaryArgument(salary)) {
            this.salary = salary;
        }
    }


    private boolean validateDepartmentArgument(int department) {
        if (department > 5 || department <= 0) {
            throw new IllegalArgumentException("Department should be in the range of [1-5].");
        }
        return true;
    }

    private boolean validateSalaryArgument(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary should be positive.");
        }
        return true;
    }


    @Override
    public String toString() {
        return "id = " + id +
                ", full name = " + fullName +
                ", department = " + department +
                ", salary = " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}