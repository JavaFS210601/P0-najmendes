package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountsDao;
import com.revature.daos.PlayerDao;
import com.revature.gamelogic.GameMenu;
import com.revature.gamelogic.SimulationInfo;


public class Menu {
	
		PlayerDao playerDao = new PlayerDao();
		AccountsDao accountDao = new AccountsDao();
		GameMenu gameMenu = new GameMenu();
		SimulationInfo simulationInfo = new SimulationInfo();
		
		public void displayMenu() {
			
			boolean display = true;
			boolean playGame = true;
			Scanner scan = new Scanner(System.in);
			final Logger log = LogManager.getLogger(Menu.class);
			
			while (display==true) {
				System.out.println("===================================================================");
				System.out.println("                            GROW YOUR NET ");
				System.out.println("                            ------------- ");
				System.out.println("                      - Investing Simulation - "); 
				System.out.println("===================================================================\n");
				System.out.println("                      -----------------------");
				System.out.println("                         CHOOSE AN OPTION");
				System.out.println("                         ================");
				System.out.println("                      - type a word below -");	
				System.out.println("                      -----------------------\n");
				System.out.println("                  info    ->  info about simulation");
				System.out.println("                  all     ->  list of all users");
				System.out.println("                  new     ->  add new user");	
				System.out.println("                  start   ->  start simulation");	
				System.out.println("                  delete  ->  delete your user info");				
				System.out.println("                  exit    ->  exit the application");				
														
				String input = scan.nextLine().toLowerCase();
				
				switch (input){
				
					case "info":{
						simulationInfo.aboutTheSimluation();
						break;
					}
				
					case "all":{
						System.out.println("LOADING ALL USERS.....\n");
						
						List<Account> accounts = accountDao.showLeaderboard();
						
						for (Account a : accounts) {
							System.out.println(a.getPlayer_id_fk() + " --------> TOTAL ACCOUNT BALANCE $" + a.getTotal_balance());
							
						}
						break;
					}//case "leader board"				
									
					case "new":{
						System.out.println("LET'S SET UP A NEW USER ACCOUNT FOR YOU!\n");
						//inserting into to player table
						System.out.println("Enter your first name: ");
						String first_name = scan.nextLine();
						System.out.println("Enter your last name: ");
						String last_name = scan.nextLine();
						System.out.println("Choose a username (numbers not accepted): ");
						String user_name = scan.nextLine();
						
						Player newPlayer = new Player(first_name, last_name, user_name);
						playerDao.addNewPlayer(newPlayer);	
						
						System.out.println("LET'S ADD SOME MONEY TO YOUR ACCOUNT!\n");
						//inserting into account table		
//						System.out.println("Enter your username: ");
//						String player_id_fk = scan.nextLine();	
						
						System.out.println("You will be asked how much money you want \n"
								+ "to allocate to each of the following:\n"
								+ "\n"
								+ "savings account, stocks, crytocurrency and bonds.\n");
						
						System.out.println("How much money will fund your savings account?");//blurb
						int savings = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money will fund your stocks account?");//blurb
						int stocks = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money will fund your cryptocurrency account?");//blurb
						int cryptos = scan.nextInt();
						scan.nextLine();
						System.out.println("How much money will fund your bonds account?");//blurb
						int bonds = scan.nextInt();
						scan.nextLine();
						
						//"user_name" is used to represent the 'player_id_fk" for this method, so i don't have to repeatedly ask user to enter their user_name																
						Account newAccount = new Account(savings, stocks, cryptos, bonds, user_name); 
						accountDao.addNewAccount(newAccount); 
						log.info("A new user account was added to the database");
						
						System.out.println("Type \"confirm\" to confirm your request.");
						scan.nextLine();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Type \"view\" to view your account.");
						scan.nextLine();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
						break;
					}//case new game
					
															
					case "start":{
						System.out.println("\nLet's Get Started with Today's Net Growth\n"
								+ "Enter your username:");
						String user_name = scan.nextLine();
						gameMenu.playGame(user_name);
						break;
					}//case play game
				
						
					case "delete":{				
						System.out.println(
								"\nYOU CAN'T GO BACK NOW.\n"
								+ "YOU MUST MAKE A NEW ACCOUNT IF YOU EVER WANT TO PLAY AGAIN.\n");
						System.out.println("Enter your username: ");
						String user_name = scan.nextLine();
						log.warn("A user has been deleted from the database!");
						playerDao.deletePlayer(user_name);						
						break;
					}//case load game
	
														
					case "exit": {
						System.out.println("See you next time!");
						display = false;
						break;
					}//case exit
					
									
					default : {
						log.warn("Invalid input was entered!");
						System.out.println("Didn't catch that...try again.");//in case user input doesn't match any cases
						break;
					}//default case
				
				}//swicth				
			}//while-loop
		}//displayMenu method
}//class
