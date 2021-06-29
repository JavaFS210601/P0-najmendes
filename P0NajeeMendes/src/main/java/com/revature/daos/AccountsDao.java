package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.Player;
import com.revature.utils.ConnectionUtil;

public class AccountsDao implements AccountsDaoInterface{

	@Override
	public List<Account> showLeaderboard() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT player_id_fk, total_balance FROM accounts ORDER BY total_balance DESC;";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Account> accountsList = new ArrayList<>();
			
			while (rs.next()) {			
				Account account = new Account(						
//						rs.getInt("savings"),
//						rs.getInt("stocks"),
//						rs.getInt("cryptos"),
//						rs.getInt("bonds"),
						rs.getInt("total_balance"),
						rs.getString("player_id_fk")						
						);
				
				accountsList.add(account);			
			}//while
			
				return accountsList;		
			
		}catch(SQLException e ) {
			System.out.println("COULD NOT GET LEADERBOARD!\n");
			e.printStackTrace();
		}
		return null;
	}//show leader board
	
	
	
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

	
	@Override
	public List<Account> checkBalances(String player_id_fk) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM accounts WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, player_id_fk);
			
			rs = ps.executeQuery();
			
			List<Account> checkPlayerBalance = new ArrayList<>();
			
			while (rs.next()) {			
				Account assetBalances = new Account(
						rs.getInt("savings"),
						rs.getInt("stocks"),
						rs.getInt("cryptos"),
						rs.getInt("bonds"),
						rs.getInt("total_balance"),
						rs.getString("player_id_fk")						
						);
				
				checkPlayerBalance.add(assetBalances);			
			}//while			
				return checkPlayerBalance;
			
		}catch (SQLException e) {
			System.out.println("ACTION FAILED!\n");
			e.printStackTrace();
		}//catch
		
		return null;
	}//check balances
	
	
	
	
	
	@Override
	public void updateSavings(int save, String player_id_fk) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET savings = savings + ? WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, save);
			ps.setString(2, player_id_fk);
			
			System.out.println("Your [savings] asset has been updated!");
			ps.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("DEPOSITING MONEY FAILED!\n");
			e.printStackTrace();
		}		
	}//update savings



	public void updateStocks(int capital, String player_id_fk) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET stocks = stocks + ? WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, capital);
			ps.setString(2, player_id_fk);
			
			System.out.println("Your [stocks] asset has been updated!");
			ps.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("DEPOSITING MONEY FAILED!\n");
			e.printStackTrace();
		}		
	}//update stocks


	
	public void updateCryptos(int cryptos, String player_id_fk) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET cryptos = cryptos + ? WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, cryptos);
			ps.setString(2, player_id_fk);
			
			System.out.println("Your [cryptos] asset has been updated!");
			ps.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("DEPOSITING MONEY FAILED!\n");
			e.printStackTrace();
		}		
	}//update cryptos
	
	
	
	
	public void updateBonds(int bonds, String player_id_fk) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE accounts SET bonds = bonds + ? WHERE player_id_fk = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, bonds);
			ps.setString(2, player_id_fk);
			
			System.out.println("Your [bonds] asset has been updated!");
			ps.executeUpdate();
					
		}catch (SQLException e) {
			System.out.println("DEPOSITING MONEY FAILED!\n");
			e.printStackTrace();
		}		
	}//update bonds	



	@Override
	public void updateTotalBalance(String player_id_fk) {
		try(Connection conn = ConnectionUtil.getConnection()) {	
			
			String sql = " UPDATE accounts SET total_balance = (savings + stocks + cryptos + bonds) WHERE player_id_fk = ?;";
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, player_id_fk);
			
			System.out.println("Your TOTAL BALANCE has been calculated.");
			ps.executeUpdate();
			
			
		}catch (SQLException e) {
		System.out.println("DEPOSITING MONEY FAILED!\n");
		e.printStackTrace();
		}
	}
	
	
	

	
}//class
