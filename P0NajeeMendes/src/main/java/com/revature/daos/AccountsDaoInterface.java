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
	
	public List<Account> showLeaderboard();
	
	public void addNewAccount(Account account);
	
	public List<Account> checkBalances(String user_name); 
	
	public void updateSavings(int save, String player_id_fk);
	
	public void updateStocks(int capital, String player_id_fk);
		
	public void updateCryptos(int capital, String player_id_fk);
		
	public void updateBonds(int capital, String player_id_fk);
	
	public void updateTotalBalance(String player_id_fk);
	
	
}