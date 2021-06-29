package com.revature.models;

import java.util.List;
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
				System.out.println("==================================================================");
				System.out.println("                            GROW YOUR NET ");
				System.out.println("                            ------------- ");
				System.out.println("                      - Investing Simulation - "); 
				System.out.println("==================================================================\n");
				System.out.println("                      -----------------------");
				System.out.println("                      CHOOSE AN OPTION BELOW");
				System.out.println("                      ======================");
				System.out.println("                      - type a word below -");	
				System.out.println("                      -----------------------\n");
				System.out.println("                all     ->  list of users");//...have to figure out what to order it by ...? MIGHT TAKE THIS OUT THOUGH...
				System.out.println("                new     ->  add new user");	//WORKS
				System.out.println("                start   ->  start simulation");	//works
				System.out.println("                delete  ->  delete your user info");//WORKS				
				System.out.println("                exit    ->  exit the application");//WORKS				
														
				String input = scan.nextLine().toLowerCase();
				
				switch (input){
				
					case "all":{
						System.out.println("LOADING USERS' STATUS.....\n");
						
						List<Account> accounts = accountDao.showLeaderboard();
						
						for (Account a : accounts) {
							System.out.println(a.getPlayer_id_fk() + "--------> TOTAL ACCOUNT BALANCE $" + a.getTotal_balance());
							
						}
						break;
					}//case "leader board"				
									
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
//						System.out.println("Enter your username: ");
//						String player_id_fk = scan.nextLine();	
						
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
						
						//"user_name" is used to represent the 'player_id_fk" for this method, so i don't have to repeatedly ask user to enter their user_name																
						Account newAccount = new Account(savings, stocks, cryptos, bonds, user_name); 
						accountDao.addNewAccount(newAccount); 
						
						System.out.println("Enter any LETTER to calculate total balance.");
						scan.nextLine();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter any LETTER to view your account.");
						scan.nextLine();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
							System.out.println(a.getPlayer_id_fk() + " " + a.getTotal_balance());
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
