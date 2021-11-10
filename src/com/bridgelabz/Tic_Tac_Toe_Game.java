package com.bridgelabz;

public class Tic_Tac_Toe_Game {
	private static char[] element;

	public static void main(String[] args) {
		System.out.println("Welcome to the Tic Tac Toe Game !!!!!!");
        boardCreation();
    }

    private static void boardCreation() {
        element = new char[10];
        for (int i = 1; i < 10; i++) {
            element[i] = ' ';
        }
        System.out.println("Empty board created");

	}

}
