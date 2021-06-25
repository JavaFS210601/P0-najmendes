package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.PlayerDao;

public class Menu {
	
		PlayerDao playerDao = new PlayerDao();
		
		public void displayMenu() {
			
			boolean display = true;
			Scanner scan = new Scanner(System.in);
			
			while (display==true) {
				System.out.println("===========================================");
				System.out.println("             GROW YOUR NET ");
				System.out.println("      - Investment Simulation Game - ");
				System.out.println("===========================================\n");
				System.out.println("        -----------------------");
				System.out.println("        CHOOSE AN OPTION BELOW");
				System.out.println("        -----------------------\n");
				System.out.println("      new     ->  start a new game");
				System.out.println("      load    ->  continue game");
				System.out.println("      delete  ->  delete your info");
				System.out.println("      board   ->  view leader board");//can this be ordered by total_balance? yess using inner join...
				System.out.println("      exit    ->  exit");				//but i gotta connect playerdao class w/ accountdao class for this to work
														//using query: SELECT * FROM players INNER JOIN account_numbers ON player_id_fk = player_id ORDER BY total_balance DESC;
				String input = scan.nextLine().toLowerCase();
				
				switch (input){
				
					case "new":{
						System.out.println("CREATING NEW PLAYER.....\n");
						break;
					}//case new game
					
					case "load":{
						System.out.println("LOADING GAME.....\n");
						break;
					}//case load game
					
					case "delete":{
						System.out.println("LOADING GAME.....\n");
						break;
					}//case load game
					
					case "board":{
						System.out.println("LOADING LEADER BOARD.....\n");
						
						List<Player> players = playerDao.getPlayers();
						
						for (Player p : players) {
							System.out.println(p);
						}
						break;
					}//case "leaderboard"
	
					case "exit": {
						System.out.println("See you next time!");
						display = false;
						break;
					}//case exit
					
					default : {
						System.out.println("Didn't catch that...try again");//in case user input doesn't match any cases
						break;
					}//default case
				
				}//while-loop				
			}//displayMenu method
		}
}//class
