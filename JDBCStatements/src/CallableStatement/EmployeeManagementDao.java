package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeManagementDao {
	private static final String userName = "SYSTEM";
	private static final String password = "MYDB123";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String dbUrl = "jdbc:oracle:thin:@SRUJANA:1521:MYDB";
	
	Connection conn = null;

	public void addEmployeeAndShowList(Employee employee) {
		try {
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, userName, password);
			String sql = "{call insertEMPLOYEES(?,?)}";
			CallableStatement callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, employee.getEmployeeName());
			callableStatement.setInt(2, employee.getEmployeeId());
			callableStatement.executeUpdate();

			PreparedStatement st = conn.prepareStatement("SELECT * FROM EMPLOYEES");
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Employee retrievedEmployee = new Employee();
				String employeeName = rs.getString("EMPLOYEE_NAME");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				retrievedEmployee.setEmployeeName(employeeName);
				retrievedEmployee.setEmployeeId(employeeId);
				employeeList.add(retrievedEmployee);
			}
			for (int i = 0; i < employeeList.size(); i++)
				System.out.println("Employee Name: "
						+ employeeList.get(i).getEmployeeName()
						+ " Employee ID: "
						+ employeeList.get(i).getEmployeeId());
			conn.close();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}
}
