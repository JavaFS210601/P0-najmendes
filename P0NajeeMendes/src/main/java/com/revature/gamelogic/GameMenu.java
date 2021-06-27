package com.revature.gamelogic;

import java.util.Scanner;

import com.revature.daos.AccountsDao;

public class GameMenu {

	boolean startGame = true;
	
	Scanner scan = new Scanner(System.in);
	AccountsDao accountDao = new AccountsDao();
			
	public void playGame(String user_name) {		
		user_name = user_name;
		
		while(startGame == true) {
			System.out.println("            ---------------");
			System.out.println("            Choose an Asset");
			System.out.println("            ---------------\n");
			System.out.println("      (1) Save    -> Invest in Stocks");
			System.out.println("      (2) Stocks  -> Invest in Stocks");
			System.out.println("      (3) Cryptos -> Invest in Cryptocurrency");
			System.out.println("      (4) Bonds   -> Invest in Bonds");			
			System.out.println("      (5) Main    -> Go back to main page");//..add at some later later later on date
	
			int input2 = scan.nextInt();

			switch(input2) {
				case 1:{
					System.out.println("How much are you depositing to your savings?");
					int save = scan.nextInt();
					accountDao.updateSavings(save, user_name);
					//System.out.println("Enter username to check the balance of your assets.");
					//accountDao.checkBalances(user_name);
					scan.nextLine();
					break;	
				}//case 1

//math operations fore stock/bonds = in UNIT CONVERTER PROJECT FOLDER (in Testing 123)
//				case 2:{
//					System.out.println("How much are you risking on stocks?");
//					int risk = scan.nextInt();
//					accountDao.updateStocks(risk, user_name);
//					//System.out.println("Enter username to check the balance of your assets.");
//					break;	
//				}
//				case 3:{
//					System.out.println("How much are you risking on cryptos?");
//					int risk = scan.nextInt();
//					accountDao.updateCryptos(risk, user_name);
//					//System.out.println("Enter username to check the balance of your assets.");
//					break;	
//				}
//				case 4:{
//					System.out.println("How much are you risking on bonds?");
//					int risk = scan.nextInt();
//					accountDao.updateBonds(risk, user_name);
//					//System.out.println("Enter username to check the balance of your assets.");
//					break;	
//				}
				case 5:{
					scan.nextLine();
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
