package com.bridgelabz;
import java.util.Scanner;

public class Tic_Tac_Toe_Game {
	private static char[] element;
    static char userMark, computerMark;
    static Scanner scan = new Scanner(System.in);
    static int userNumber;
    
	public static void main(String[] args) {
		 System.out.println("Welcome to the Tic Tac Toe Game !!!!!!");
	        boardCreation();
	        choosingXorO();
	        currentBoard();
	        userCall();
	        userMove();
	    }

	    private static void boardCreation() {
	        element = new char[10];
	        for (int i = 1; i < 10; i++) {
	            element[i] = ' ';
	        }
	    }

	    private static void choosingXorO() {
	        System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");
	        int option = scan.nextInt();
	        switch (option) {
	            case 1:
	                userMark = 'X';
	                computerMark = 'O';
	                break;
	            case 2:
	                userMark = 'O';
	                computerMark = 'X';
	                break;
	            default:
	                System.out.println("Your input is invalid");
	                choosingXorO();
	        }
	    }

	    private static void currentBoard() {
	        for (int i = 1; i < 10; i++) {
	            if (element[i] != 'X' && element[i] != 'O') {
	                element[i] = (char) (i + '0');
	            }
	        }
	        displayingBoard();
	    }

	    private static void displayingBoard() {
	        System.out.println("\n  " + element[1] + " | " + element[2] + " | " + element[3] + " ");
	        System.out.println(" ----------- ");
	        System.out.println("  " + element[4] + " | " + element[5] + " | " + element[6] + " ");
	        System.out.println(" ----------- ");
	        System.out.println("  " + element[7] + " | " + element[8] + " | " + element[9] + " \n");
	    }

	    private static void userCall() {
	        System.out.println("\nEnter a number from board to make the mark:\n");
	        userNumber = scan.nextInt();
	        if (userNumber < 1 || userNumber > 9) {
	            currentBoard();
	            System.out.println("Your input is Invalid");
	            userCall();
	        }
	    }

	    private static void userMove() {
	        if (element[userNumber] == 'X' || element[userNumber] == 'O') {
	            currentBoard();
	            System.out.println("Number which is selected is not free");
	            userCall();
	            userMove();
	        } else {
	            element[userNumber] = userMark;
	            System.out.println(userMark + " user is marked " + userNumber);
	        }
	    }
	}