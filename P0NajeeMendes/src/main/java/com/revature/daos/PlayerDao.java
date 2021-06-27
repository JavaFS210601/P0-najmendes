package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Player;
import com.revature.utils.ConnectionUtil;

public class PlayerDao implements PlayerDaoInterface {

//	//this method needs to be w/ accounts dao to order leader board by total_balance in descending order
//	@Override 
//	public List<Player> getPlayers() {
//
//		try (Connection conn = ConnectionUtil.getConnection()){
//			
//			ResultSet rs = null;
//			
//			String sql = "SELECT first_name, last_name, user_name FROM players;";
//			
//			Statement s = conn.createStatement();
//			
//			rs = s.executeQuery(sql);
//			
//			List<Player> playerList = new ArrayList<>();
//			
//			while(rs.next()) {
//				Player player = new Player(
//						rs.getString("first_name"),
//						rs.getString("last_name"),
//						rs.getString("user_name")				
//						);
//				
//				playerList.add(player);
//			}//while
//			return playerList;
//		}catch(SQLException e){
//			System.out.println("Something went wrong when trying to access your database");
//			e.printStackTrace();
//		}
//		return null;
//	}//getPLayers

	




	@Override
	public void addNewPlayer(Player player) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO players (first_name, last_name, user_name)"
					+ "VALUES (? , ? , ?);";
					
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, player.getFirst_name());
			ps.setString(2, player.getLast_name());
			ps.setString(3, player.getUser_name());
			
			ps.executeUpdate();
			
			System.out.println("New player has been created for: " + player.getUser_name() + "\n");
					
		}catch(SQLException e) {
			System.out.println("CREATING NEW PLAYER ACCOUNT FAILED!\n");
			e.printStackTrace();
			
		}//catch		
	}//addNewPlayer()
	
	

	@Override
	public void deletePlayer(String user_name) {
		user_name = user_name;
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "DELETE FROM players WHERE user_name = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user_name);
			
			ps.executeUpdate();
			System.out.println(user_name + " has been deleted from the system!\n");
					
		}catch (SQLException e) {
			System.out.println("DELETING PLAYER ACCOUNT FAILED!\n");
			e.printStackTrace();
			
		}//catch		
	}//delete player



//	@Override //make this method more like a update plaers records...wjere the loaded game will jump srtaight to game functionality
//	public Player loadSavedPlayer(String user_name) {
//
//		try (Connection conn = ConnectionUtil.getConnection()){
//			
//			String sql = "SELECT * FROM players WHERE user_name = " + user_name + ");";			
//			PreparedStatement ps = conn.prepareStatement(sql);	
//			
//			//ps.setString(1, "user_name");
//			ResultSet rs = ps.executeQuery(sql);
//			System.out.println("Welcome back " + user_name + "!");
//			
//			
//				
//		}catch(SQLException e){
//			System.out.println("Something went wrong when trying to access your database\n");
//			e.printStackTrace();
//		}
//		return null;		
//	}//load saved player //the way it is right now makes no sense b/c you can't use excesuteQuery w/ preparedStatements, and you can't use
//	//specifics (where) w/ regular statements. ALSO the way it is now, is returning a value, and for how this method is being used,
//	//it doesn't need anything return...it just needs a confirmation that this record is on the table.
//	//i will change the method so that it is more like the updateRole in the PO Demo, so that when player chooses "load game"
//	//they will enter their user_name and the game will begin based off of the records associated w/ that username!
//
//	
//	//but for it to update I have to work on functionality in the AccountsDao.
//	
//	

	
}//class
