package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Player;
import com.revature.utils.ConnectionUtil;

public interface AccountsDaoInterface {
	
	public void addNewAccount(Account account);
	
	public List<Account> checkBalances(String user_name); //work on getting player's money status...add to end of add new player case
	
	public void updateSavings(int save, String player_id_fk);
	
	//public void updateStocks(int ...);
	
	//public void updateCryptos(int ...);
	
	//public void updateBonds(int ...);
	


}

//public List<Employee> getEmployees() {
//	
//	try(Connection conn = ConnectionUtil.getConnection()){//try to establish a db connection to run a query
//		
//		ResultSet rs = null; //inistialize an empty result set that will store results of our query
//		
//		String sql = "SELECT * FROM employees;";//write the query, assign it to a String variable
//		
//		Statement s = conn.createStatement(); //creating an object to send the query to out db
//		
//		rs = s.executeQuery(sql);//execute the query (sql), using our Statement object (s), 
//								//put it in our result set(rs) 
//		
//		List<Employee> employeeList = new ArrayList<>();//create a list that will be populated w/ the returned employees
//		
//		while(rs.next()) {//while there are results left in the ResultSet(rs) do this...
//			
//			//create a new employee object from each returned row(record)
//			Employee employee = new Employee(
//					rs.getInt("employee_id"),
//					rs.getString("f_name"),
//					rs.getString("l_name"),
//					rs.getString("hire_date"),
//					rs.getInt("role_id")		
//				);
//			
//			//add newly created employee object into ArrayList of Employees		
//			employeeList.add(employee);
//			
//		}//while
//			return employeeList; //Finally, if successful, return the List of Employees
//			
//	}catch(SQLException e){//if something goes wrong accessing data, it will get caught
//		System.out.println("Something went wrong when trying to access your database");
//		e.printStackTrace();
//	}//catch
//	
//	return null;//java will yell if we don't have this, cuz the try isn't guarentees to succeed
//	
//}//getEmployees()