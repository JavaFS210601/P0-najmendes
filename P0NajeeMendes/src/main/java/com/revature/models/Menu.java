package com.revature.models;

import java.util.Scanner;

import com.revature.daos.AccountsDao;
import com.revature.daos.PlayerDao;
import com.revature.gamelogic.GameMenu;


public class Menu {
	
		PlayerDao playerDao = new PlayerDao();
		AccountsDao accountDao = new AccountsDao();
		GameMenu gameMenu = new GameMenu();
		
		public void displayMenu() {
			
			boolean display = true;
			boolean playGame = true;
			Scanner scan = new Scanner(System.in);
			
			while (display==true) {
				System.out.println("===========================================");
				System.out.println("             GROW YOUR NET ");
				System.out.println("      - Investing Simulation Game - "); //OR just - Investing Simulation - ...?
				System.out.println("===========================================\n");
				System.out.println("        -----------------------");
				System.out.println("        CHOOSE AN OPTION BELOW");
				System.out.println("        -----------------------\n");
				System.out.println("      board   ->  view leader board");//can this be ordered by total_balance? yess using inner join...
				System.out.println("      new     ->  add new player");	//but i gotta connect playerdao class w/ accountdao class for this to work
				System.out.println("      play    ->  play game");		//using query: SELECT * FROM players INNER JOIN account_numbers ON player_id_fk = player_id ORDER BY total_balance DESC;
				System.out.println("      delete  ->  delete your info");				
				System.out.println("      exit    ->  exit");				
														
				String input = scan.nextLine().toLowerCase();
				
				switch (input){
				
//					case "board":{
//						System.out.println("LOADING LEADER BOARD.....\n");
//						
//						List<Player> players = playerDao.getPlayers();
//						
//						for (Player p : players) {
//							System.out.println(p);
//						}
//						break;
//					}//case "leader board"
				
									
					case "new":{
						System.out.println("LET'S SET UP A NEW PLAYER FOR YOU!\n");
						//inserting into to player table
						System.out.println("Enter your first name: ");
						String first_name = scan.nextLine();
						System.out.println("Enter your last name: ");
						String last_name = scan.nextLine();
						System.out.println("Choose a username: ");
						String user_name = scan.nextLine();
						
						Player newPlayer = new Player(first_name, last_name, user_name);
						playerDao.addNewPlayer(newPlayer);	
						
						System.out.println("LET'S ADD SOME MONEY TO YOUR ACCOUNT!\n");
						//inserting into account table		
						System.out.println("Enter your username: ");
						String player_id_fk = scan.nextLine();	
						
						System.out.println("Now...take some time to think about how you want to stash you cash.\n"
								+ "You will be asked how much money you want to allocate to each of the following assets:\n"
								+ "savings account, stocks, crytocurrency and bonds.\n"
								+ "Chose wisely.\n");
						
						System.out.println("How much money do you want to add to your savings account?");
						int savings = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money do you want to invest in stocks?");
						int stocks = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money do you want to invest in cryptocurrency?");
						int cryptos = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money do you want to invest in bonds?");
						int bonds = scan.nextInt();
						scan.nextLine();
																
						Account newAccount = new Account(savings, stocks, cryptos, bonds, player_id_fk);
						accountDao.addNewAccount(newAccount); 
						
//						System.out.println("Enter username to access account information.");
//						user_name = scan.nextLine();
						
						break;
					}//case new game
					
															
					case "play":{
						System.out.println("\nLet's Get Started with Today's Net Growth\n"
								+ "Enter your username:");
						String user_name = scan.nextLine();
						//gameMenu.playGame(user_name);
						accountDao.checkBalances(user_name);
						break;
					}//case play game
				
						
					case "delete":{
						System.out.println("\nDELETING PLAYER ACCOUNT CANNOT BE UNDONE.\n"
								+ "YOU MUST MAKE A NEW ACCOUNT IF YOU EVER WANT TO PLAY AGAIN!\n");
						System.out.println("Enter your username: ");
						String user_name = scan.nextLine();
						playerDao.deletePlayer(user_name);
						
						break;
					}//case load game
	
														
					case "exit": {
						System.out.println("See you next time!");
						display = false;
						break;
					}//case exit
					
									
					default : {
						System.out.println("Didn't catch that...try again");//in case user input doesn't match any cases
						break;
					}//default case
				
				}//swicth				
			}//while-loop
		}//displayMenu method
}//class
