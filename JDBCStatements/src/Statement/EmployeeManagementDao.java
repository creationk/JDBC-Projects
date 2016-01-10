package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeManagementDao {
	private static final String userName = "SYSTEM";
	private static final String password = "";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String dbUrl = "jdbc:oracle:thin:@HOST:1521:DB";

	Connection conn = null;

	public void addEmployeeAndShowList(Employee employee) {
		try {
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, userName, password);
			Statement st = conn.createStatement();
			String sql = "INSERT INTO EMPLOYEES VALUES('"
					+ employee.getEmployeeName() + "',"
					+ employee.getEmployeeId() + ")";
			st.executeUpdate(sql);
			conn.commit();
			sql = "SELECT * FROM EMPLOYEES";
			ResultSet rs = st.executeQuery(sql);
			conn.commit();
			while (rs.next()) {
				Employee retrievedEmployee = new Employee();
				String employeeName = rs.getString("NAME");
				int employeeId = rs.getInt("ID");
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
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
