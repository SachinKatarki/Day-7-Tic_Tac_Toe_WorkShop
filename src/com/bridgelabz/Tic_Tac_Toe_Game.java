package com.bridgelabz;
import java.util.Scanner;
import java.util.Random;

public class Tic_Tac_Toe_Game {
	 private static char[] element;
	    static char userMark, computerMark;
	    static Scanner scan = new Scanner(System.in);
	    private static final Random random = new Random();
	    static int userNumber, computerNumber;
	    static int turn = 1, flag = 0;

    
	public static void main(String[] args) {
		 System.out.println("Welcome to the Tic Tac Toe Game !!!!!!");
	        boardCreation();
	        displayingBoard();
	        choosingXorO();
	        tossCoin();
	        outerloop:
	        while (flag == 0) {
	            if ((turn + 1) % 2 == 0) {
	                flag = checkTie();
	                if (flag != 0) {
	                    System.out.println("Nice Play! It's Tie");
	                    ;
	                    break outerloop;
	                }
	                currentBoard();
	                userCall();
	                userMove();
	                flag = checkWin();
	                if (flag != 0) {
	                    System.out.println("Excellent! You are the winner");
	                    break outerloop;
	                }
	                turn++;
	            } else {
	                flag = checkTie();
	                if (flag != 0) {
	                    System.out.println("Nice Play! It's Tie");
	                    ;
	                    break outerloop;
	                }
	                flag = computerWin();
	                if (flag == 1) {
	                    break outerloop;
	                }
	                for (int i = 1; i <= 3; i++) {
	                    switch (i) {
	                        case 1:
	                            flag = computerBlock();
	                            break;
	                        case 2:
	                            flag = computerCorner();
	                            break;
	                        default:
	                            flag = computerCenterSide();
	                    }
	                    if (flag == 1) {
	                        turn++;
	                        flag = 0;
	                        break;
	                    }
	                }
	            }
	        }
	        gameAgain();
	    }

	    private static void boardCreation() {
	        element = new char[10];
	        for (int i = 1; i < 10; i++) {
	            element[i] = ' ';
	        }
	    }

	    private static void choosingXorO() {
	        System.out.println("Select your mark\n\nChoose '1' for X\nChoose '2' for O");
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
	        System.out.println("\nYour mark is '" + userMark + "' & Computer Mark:'" + computerMark + "'");
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
	        System.out.println("Enter a number from board to make the mark:");
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
	            System.out.println("You choose number " + userNumber);
	            element[userNumber] = userMark;
	        }
	    }


	    private static void tossCoin() {
	        System.out.println("\nMaking a toss to check who plays first\nChoose '1' for HEAD\nChoose '2' for TAIL");
	        int option = scan.nextInt();
	        if (option == 1 || option == 2) {
	            int flip = random.nextInt(2) + 1;
	            if (flip == 1) {
	                System.out.println("\nBy tossing Coin it shows HEAD\n");
	            } else {
	                System.out.println("\nBy tossing Coin it shows TAIL\n");
	            }
	            if (flip == option) {
	                System.out.println("You have to start the game");
	            } else {
	                System.out.println("Computer will start the game");
	                turn++;
	            }
	        } else {
	            System.out.println("\nInvalid input Choose number from below");
	            tossCoin();
	        }
	    }

	    public static void computerFirstTurn() {
	        computerNumber = random.nextInt(9) + 1;
	        element[computerNumber] = computerMark;
	        System.out.println("Computer choses '" + computerNumber + "' now user turn");
	    }

	    private static int checkWin() {
	        for (int i = 1; i < 9; i++) {
	            int win[] = winArray(i);
	            if (element[win[0]] == element[win[1]] && element[win[1]] == element[win[2]]) {
	                flag = 1;
	            }
	        }
	        return flag;
	    }

	    private static int[] winArray(int number) {
	        if (number == 1) {
	            int arrayWin[] = {1, 2, 3};
	            return arrayWin;
	        } else if (number == 2) {
	            int arrayWin[] = {4, 5, 6};
	            return arrayWin;
	        } else if (number == 3) {
	            int arrayWin[] = {7, 8, 9};
	            return arrayWin;
	        } else if (number == 4) {
	            int arrayWin[] = {1, 4, 7};
	            return arrayWin;
	        } else if (number == 5) {
	            int arrayWin[] = {2, 5, 8};
	            return arrayWin;
	        } else if (number == 6) {
	            int arrayWin[] = {3, 6, 9};
	            return arrayWin;
	        } else if (number == 7) {
	            int arrayWin[] = {1, 5, 9};
	            return arrayWin;
	        } else {
	            int arrayWin[] = {3, 5, 7};
	            return arrayWin;
	        }
	    }

	    private static int checkTie() {
	        for (int i = 1; i < 10; i++) {
	            if (element[i] == 'X' || element[i] == 'O') {
	                if (i == 9) {
	                    flag = 1;
	                } else {
	                    continue;
	                }
	            } else {
	                break;
	            }
	        }
	        return flag;
	    }

	    private static int winBlock(char playerMark, char opponentMark) {
	        int winBlock[] = new int[3];
	        for (int i = 1; i < 9; i++) {
	            winBlock = winArray(i);
	            if (element[winBlock[0]] == element[winBlock[1]] && element[winBlock[0]] == playerMark && element[winBlock[2]] != opponentMark) {
	                flag = winBlock[2];
	                break;
	            } else if (element[winBlock[0]] == element[winBlock[2]] && element[winBlock[2]] == playerMark && element[winBlock[1]] != opponentMark) {
	                flag = winBlock[1];
	                break;
	            } else if (element[winBlock[1]] == element[winBlock[2]] && element[winBlock[2]] == playerMark && element[winBlock[0]] != opponentMark) {
	                flag = winBlock[0];
	                break;
	            }
	        }
	        return flag;
	    }

	    private static int computerWin() {
	        int index = winBlock(computerMark, userMark);
	        if (index != 0) {
	            element[index] = computerMark;
	            System.out.println("Computer choose '" + index + "'");
	            currentBoard();
	            System.out.println("Computer won. Better Luck next time");
	            flag = 1;
	        }
	        return flag;
	    }

	    private static int computerBlock() {
	        int index = winBlock(userMark, computerMark);
	        if (index != 0) {
	            element[index] = computerMark;
	            System.out.println("Computer goes for '" + index + "' to block you");
	            flag = 1;
	        }
	        return flag;
	    }

	    private static int computerCorner() {
	        int corner[] = {7, 3, 1, 9};
	        flag = computerOption(corner);
	        return flag;
	    }


	    private static int computerCenterSide() {
	        if (element[5] != 'X' && element[5] != 'O') {
	            element[5] = computerMark;
	            System.out.println("Computer choice is '5'");
	            flag = 1;
	        } else {
	            int side[] = {2, 6, 8, 4};
	            flag = computerOption(side);
	        }
	        return flag;
	    }

	    private static int computerOption(int[] array) {
	        for (int j = 0; j < 4; j++) {
	            if (element[array[j]] != 'X' && element[array[j]] != 'O') {
	                element[array[j]] = computerMark;
	                System.out.println("Computer choice is '" + array[j] + "'");
	                flag = 1;
	                break;
	            }
	        }
	        return flag;
	    }

	    private static void gameAgain() {
	        System.out.println("\nWanna play again. 1) Restart 2) Exit");
	        int option = scan.nextInt();
	        if (option == 1) {
	            String[] args = {};
	            main(args);
	        } else {
	            System.exit(1);
	        }
	    }

	}