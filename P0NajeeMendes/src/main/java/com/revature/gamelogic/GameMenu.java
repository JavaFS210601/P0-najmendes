package com.revature.gamelogic;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.AccountsDao;
import com.revature.models.Account;
import com.revature.models.Menu;
import com.revature.models.Player;

public class GameMenu {

	boolean startGame = true;
	
	Scanner scan = new Scanner(System.in);
	AccountsDao accountDao = new AccountsDao();
	SimulationInfo simulationInfo = new SimulationInfo();
	final Logger log = LogManager.getLogger(GameMenu.class);//change to GameMenu.class...!?
			
	public void playGame(String user_name) {		
		user_name = user_name;
		
		
		while(startGame == true) {
			System.out.println("                      -----------------------");
			System.out.println("                            INVESTMENTS         ");
			System.out.println("                            ===========         ");
			System.out.println("                   - enter number option below -");			
			System.out.println("                      -----------------------\n");
			System.out.println("                 (1)     ->   View your account");	
			System.out.println("                 (2)     ->   More info ");
			System.out.println("                 (3)     ->   Deposit into savings (inflation**) ");  
			System.out.println("                 (4)     ->   Invest in Stocks (moderate-aggressive*)");  
			System.out.println("                 (5)     ->   Invest in Cryptocurrency (AGGRESSIVE*)"); 
			System.out.println("                 (6)     ->   Invest in Bonds (conservative*)"); 
			System.out.println("                 (7)     ->   Go back to main menu\n\n"); 
			System.out.println("             * Level of risk. People usually chooses based on their\n"
							 + "               individual risk tolerance.");
			System.out.println("             ** A savings account is an asset that puts your money\n"
							 + "                at higher risk of inflation.");
			
			
			
			int input2 = scan.nextInt();
			scan.nextLine();

			switch(input2) {
			
				case 1:{
		
					List<Account> accountStats = accountDao.checkBalances(user_name);
					
					for (Account a : accountStats) {
						System.out.println(a);
					}					
					break;
				}//stats case
			
				case 2:{
					simulationInfo.aboutTheAssets();							
					break;
				}//learn
			
				case 3:{
					System.out.println("How much are you depositing to your savings?");
					int save = scan.nextInt();
					int capital = save + (int)(Math.random() * 2);//i really like this number for savings
					accountDao.updateSavings(capital, user_name);
					scan.nextLine();
					
						System.out.println("Enter 1 to confirm request.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter 1 to view your account balance.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}					
					break;	
				}//savings case
				
				case 4:{
					System.out.println("How much are you depositing to invest in stocks?");
					int risk = scan.nextInt();
					int capital = risk + (int)(Math.random() * 130);
					accountDao.updateStocks(capital, user_name);
					scan.nextLine();
					
						System.out.println("Enter 1 to confirm request.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter 1 to view your balances.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
					
					break;	
				}
				
				case 5:{
					System.out.println("How much are you depositing to invest in cryptocurrency?\n");
					int risk = scan.nextInt();
					int mysteryGains = 1 + (int)(Math.random() * 3);
					int gains = risk * mysteryGains; 		
						if(mysteryGains<2) {
							gains = -gains*(1 + (int)(Math.random() * 10));
						}
						else if (mysteryGains>2) {
							gains = gains*(1 + (int)(Math.random() * 10));							
						}
						accountDao.updateCryptos(gains, user_name);
						scan.nextLine();
						
							System.out.println("Enter 1 to confirm request.");
							scan.nextInt();
							accountDao.updateTotalBalance(user_name);
							
							System.out.println("Enter 1 to view your balances.");
							scan.nextInt();
							
							List<Account> accountStats = accountDao.checkBalances(user_name);
							
							for (Account a : accountStats) {
								System.out.println(a);
							}
					break;	
				}
				
				case 6:{
					System.out.println("How much are you depositing to invest in bonds?\n");
					int risk = scan.nextInt();
					int capital = risk + (int)(Math.random() * 70);				
					accountDao.updateBonds(capital, user_name);
					scan.nextLine();	
					
						System.out.println("Enter 1 to confirm request.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter 1 to view your balances.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
					break;	
				}	
				
				case 7:{
					log.info("User has exited simulation!");
					startGame = false;
					break;	
				}	
				
				default:{
					log.warn("Invalid input was entered!");
					System.out.println("Didn't catch that...try again.");
					scan.nextLine();
					break;	
				}				
			}//swicth				
		}//while
	}//playGame
}//class
