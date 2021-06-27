package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Player;
import com.revature.utils.ConnectionUtil;

public class AccountsDao implements AccountsDaoInterface{

	@Override
	public void addNewAccount(Account account) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO accounts (savings, stocks, cryptos, bonds, player_id_fk)"
					+ "VALUES (?, ?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, account.getSavings());
			ps.setInt(2, account.getStocks());
			ps.setInt(3, account.getCryptos());
			ps.setInt(4, account.getBonds());
			ps.setString(5, account.getPlayer_id_fk());
			
			
			ps.executeUpdate();
			
			System.out.println(account.getPlayer_id_fk() + "... your money has been added!\n");
			
		}catch(SQLException e ) {
			System.out.println("CREATING NEW ACCOUNT FAILED!\n");
			e.printStackTrace();
		}//catch		
	}//add new account

	
//	@Override
//	public List<Account> checkBalances(String user_name) {
//		user_name = user_name;
//		try(Connection conn = ConnectionUtil.getConnection()){
//			
//			String sql = "SELECT * FROM players INNER JOIN accounts"
//					+ "ON player_id_fk = user_name WHERE user_name = ?;";
//			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ps.setString(1, user_name);
//			
//			ResultSet rs = ps.executeQuery(sql);
//			
//		}catch (SQLException e) {
//			System.out.println("ACTION FAILED!\n");
//			e.printStackTrace();
//		}
//		
//		return null;
//	}//check balances
	
	
	
	
	
	@Override
	public void updateSavings(int save, String player_id_fk) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET savings = savings + ? WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, save);
			ps.setString(2, player_id_fk);
			
			System.out.println("Your money has been deposited!");
			ps.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("DEPOSITING MONEY FAILED!\n");
			e.printStackTrace();
		}		
	}//update savings



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
