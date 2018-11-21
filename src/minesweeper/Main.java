package minesweeper;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static Scanner sc;

	public static void main(String[] args) {

		Random random = new Random();
		;

		int row = check("row");
		int column = check("column");
		int mines = check("mine");

		char[][] minefield = new char[row][column];

		for (char[] n : minefield) {
			Arrays.fill(n, 'O');
		}

		for (int i = 0; i < mines; i++) {
			int ran1 = random.nextInt(row);
			int ran2 = random.nextInt(column);
			if (minefield[ran1][ran2] != 'X') {
				minefield[ran1][ran2] = 'X';
			} else {
				mines = mines + 1;
			}
		}

		for (int x = 0; x < minefield.length; x++) {
			System.out.println();
			for (int y = 0; y < minefield[x].length; y++) {
				System.out.print(minefield[x][y]);
			}
		}

	}

	public static int check(String var) {

		sc = new Scanner(System.in);
		int input = 0;

		boolean badInput = true;

		do {
			System.out.println("Enter the number of " + var + "s for the minefield:");
			try {
				
				input = Integer.parseInt(sc.nextLine());
				
				if (input > 0 && input < 101) {
					badInput = false;
				}
			} catch (java.lang.NumberFormatException e) {
				System.out.println("Please enter a valid number.");
			} finally {
				if (input < 0 || input > 101) {
					System.out.println("Please enter a valid number.");
				}
			}
		} while (badInput);

		
		return input;

	}
	
}
