package pro.sky.java.course1.coursework;

/**
 * A program that check Employee and EmployeeBook classes workability.
 *
 * @author Askar Gizatullin
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook(10);

        employeeBook.addEmployee("Jon Snow", 1, 70_000);
        employeeBook.addEmployee("Rob Stark", 1, 64_000);
        employeeBook.addEmployee("Sansa Stark", 2, 45_000);
        employeeBook.addEmployee("Arya Stark", 2, 50_000);
        employeeBook.addEmployee("Jaime Lannister", 3, 59_000);
        employeeBook.addEmployee("Tyrion Lannister", 4, 65_000);
        employeeBook.addEmployee("Daenerys Targaryen", 5, 88_088);


        System.out.println("\n");

        employeeBook.printAllEmployeesInformation();

        System.out.println("=========================================================================================");

        employeeBook.printEmployeeWithMaximalSalary();
        employeeBook.printEmployeeWithMinimalSalary();
        employeeBook.printTotalSalary();
        employeeBook.printAverageSalary();

        System.out.println("=========================================================================================");

        employeeBook.printAllEmployeesFullName();


        System.out.println();
        System.out.println("=========================================================================================");
        System.out.println("=========================================================================================");
        System.out.println();


        employeeBook.indexAllEmployeesSalary(5.55);
        employeeBook.printAllEmployeesInformation();

        System.out.println("=========================================================================================");

        employeeBook.printEmployeeWithMaximalSalaryByDepartment(1);
        employeeBook.printEmployeeWithMinimalSalaryByDepartment(1);
        employeeBook.printTotalSalaryByDepartment(1);
        employeeBook.printAverageSalaryByDepartment(1);
        employeeBook.indexAllEmployeesSalaryByDepartment(1, 4.49);
        employeeBook.printAllEmployeesInformationByDepartment(1);

        System.out.println("=========================================================================================");

        employeeBook.printEmployeesWithSalaryLessThanNumber(65_000);
        employeeBook.printEmployeesWithSalaryGreaterThanNumber(65_000);


        System.out.println();
        System.out.println("=========================================================================================");
        System.out.println("=========================================================================================");
        System.out.println();


        employeeBook.addEmployee("Johnny Snowie", 1, 88_888);
        employeeBook.printAllEmployeesInformationByDepartment(1);
        employeeBook.removeEmployee(8);
        employeeBook.printAllEmployeesInformationByDepartment(1);

        System.out.println("=========================================================================================");

        employeeBook.editEmployeesSalary(1, 77_777);
        employeeBook.printAllEmployeesInformationByDepartment(1);
        employeeBook.editEmployeesDepartment(1, 2);
        employeeBook.printAllEmployeesInformationByDepartment(2);

        System.out.println("=========================================================================================");

        employeeBook.printAllEmployeesFullNameAccordingToDepartment();
    }
}