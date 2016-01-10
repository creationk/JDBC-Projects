package PreparedStatement;

import java.util.Scanner;

public class EmployeeManagementDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeManagementDao employeeManagement = new EmployeeManagementDao();
		Employee employee = new Employee();
		System.out.println("Enter Employee Name: ");
		employee.setEmployeeName(sc.nextLine());
		System.out.println("Enter Employee ID: ");
		employee.setEmployeeId(sc.nextInt());
		sc.close();
		employeeManagement.addEmployeeAndShowList(employee);

	}

}
