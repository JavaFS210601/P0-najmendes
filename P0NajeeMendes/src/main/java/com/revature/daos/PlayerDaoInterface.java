package com.revature.daos;

import java.util.List;

import com.revature.models.Player;

public interface PlayerDaoInterface {

	//public List<Player> getPlayers();
	
	public void addNewPlayer(Player player);
	
	public void deletePlayer(String user_name);
	
	//public Player loadSavedPlayer(String user_name);
	
	
	
	
	
	
}
