package pro.sky.java.course1.coursework;

public class Employee {
    private static int idCounter;
    private final int id;
    private final String fullName;
    private int department;
    private int salary;


    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        if (validateDepartmentArgument(department)) {
            this.department = department;
        }
        this.salary = salary;
        id = idCounter;
        idCounter++;
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

    private boolean validateDepartmentArgument(int department) {
        if (department > 5 || department <= 0) {
            throw new IllegalArgumentException("Department should be in the range of [1-5].");
        }
        return true;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", full name = " + fullName +
                ", department = " + department +
                ", salary = " + salary;
    }
}
