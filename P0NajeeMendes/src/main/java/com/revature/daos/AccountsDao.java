package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}//class
