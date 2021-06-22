package com.revature.models;

import java.util.Scanner;

import com.revature.daos.PlayerCollection;

public class Menu {
	
		PlayerCollection pc = new PlayerCollection();
		
		public void displayMenu() {
			
			boolean display = true;
			Scanner scan = new Scanner(System.in);
			
			while (display==true) {
				System.out.println("  \n    Welcome to Grow Your Net");
				System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~\n");
				System.out.println("    CHOOSE AND OPTION BELOW\n");
				System.out.println("NewGame -> start a new game");
				System.out.println("LoadGame -> continue saved game");
				System.out.println("Exit -> exit");
				
				String input = scan.nextLine();
				if (input.equalsIgnoreCase("newgame")) {
					//pc.addNewPlayer(name, age);
					
					//gl.playGame();
					
				} else if (input.equalsIgnoreCase("loadgame")) {
					//pc.getExistingPlayer(name, age);
					
					//gl.playGame(); //gamelogic object (gl)
					
				} else if (input.equalsIgnoreCase("exit")) {
					System.out.println("Bye");
					display = false;
				}
			
				
			}//while-loop				
	}//displayMenu method
}//class
