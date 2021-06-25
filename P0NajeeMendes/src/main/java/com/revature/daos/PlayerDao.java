package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Player;
import com.revature.utils.ConnectionUtil;

public class PlayerDao implements PlayerDaoInterface {

	@Override
	public List<Player> getPlayers() {

		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT player_id, user_name FROM players;";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Player> playerList = new ArrayList<>();
			
			while(rs.next()) {
				Player player = new Player(
						rs.getInt("player_id"),
						rs.getString("user_name")				
						);
				
				playerList.add(player);
			}//while
			return playerList;
		}catch(SQLException e){
			System.out.println("Something went wrong when trying to access your database");
			e.printStackTrace();
		}
		return null;
	}//getPLayers
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
