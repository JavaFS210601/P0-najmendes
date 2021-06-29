package com.revature.gamelogic;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountsDao;
import com.revature.models.Account;
import com.revature.models.Player;

public class GameMenu {

	boolean startGame = true;
	
	Scanner scan = new Scanner(System.in);
	AccountsDao accountDao = new AccountsDao();
			
	public void playGame(String user_name) {		
		user_name = user_name;
		
		while(startGame == true) {
			System.out.println("                      -----------------------");
			System.out.println("                              ASSETS         ");
			System.out.println("                              ======         ");
			System.out.println("                   - enter number option below -");			
			System.out.println("                      -----------------------\n");
			System.out.println("           (1) Balance  ->  View balance of your assets");	//works
			System.out.println("           (2) Save     ->  Deposit into savings (inflation**) "); //works ...need update & blurb on savings
			System.out.println("           (3) Stocks   ->  Invest in Stocks (moderate-aggressive*)"); //works ...need update & blurb on savings
			System.out.println("           (4) Cryptos  ->  Invest in Cryptocurrency (AGGRESSIVE*)"); //works
			System.out.println("           (5) Bonds    ->  Invest in Bonds (conservative*)"); //works
			//at withdrawal method???
			System.out.println("           (6) Main     ->  Go back to main menu\n\n"); //works
			System.out.println("           * Level of risk associated with asset. Person usually \n"
							 + "             chooses based on their individual risk tolerance.");
			System.out.println("           ** A savings account is an asset that puts your money\n"
							 + "              at higher risk of inflation.");
			
			
			
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
					System.out.println("How much are you depositing to your savings?");
					int save = scan.nextInt();
					int capital = save + (int)(Math.random() * 2);//i really like this number for savings
					accountDao.updateSavings(capital, user_name);
					scan.nextLine();
					
						System.out.println("Enter any digit to update total balance.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter any digit to view your account.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
					
					break;	
				}//savings case
				
				case 3:{
					System.out.println("How much are you depositing to invest in stocks?");
					int risk = scan.nextInt();
					int capital = risk + (int)(Math.random() * 130);
					accountDao.updateStocks(capital, user_name);
					scan.nextLine();
					
						System.out.println("Enter any digit to update total balance.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter any digit to view your account.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
					
					break;	
				}
				
				case 4:{
					System.out.println("How much are you depositing to invest in cryptocurrency?");
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
						
							System.out.println("Enter any digit to update total balance.");
							scan.nextInt();
							accountDao.updateTotalBalance(user_name);
							
							System.out.println("Enter any digit to view your account.");
							scan.nextInt();
							
							List<Account> accountStats = accountDao.checkBalances(user_name);
							
							for (Account a : accountStats) {
								System.out.println(a);
							}
					break;	
				}
				
				case 5:{
					System.out.println("How much are you depositing to invest in bonds?");
					int risk = scan.nextInt();
					int capital = risk + (int)(Math.random() * 70);				
					accountDao.updateBonds(capital, user_name);
					scan.nextLine();	
					
						System.out.println("Enter any digit to update total balance.");
						scan.nextInt();
						accountDao.updateTotalBalance(user_name);
						
						System.out.println("Enter any digit to view your account.");
						scan.nextInt();
						
						List<Account> accountStats = accountDao.checkBalances(user_name);
						
						for (Account a : accountStats) {
							System.out.println(a);
						}
					break;	
				}	
				
				case 6:{
					startGame = false;
					break;	
				}	
				
				default:{
					System.out.println("Sorry, I don't understand");
					scan.nextLine();
					break;	
				}				
			}//swicth				
		}//while
	}//playGame
}//class
