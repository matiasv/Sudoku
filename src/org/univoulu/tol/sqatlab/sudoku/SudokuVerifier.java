package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
	public static final int VALID = 0;
	public static final int R1_VIOLATION = -1;
	
	public int verify(String candidateSolution) {
		//simple failure cases first
		if(null == candidateSolution) {
			return R1_VIOLATION;
		} 
		
		if(candidateSolution.length() != 81) {
			return R1_VIOLATION;
		}
		
		//check that the candidate solution contains only digits 
		//from 1 to 9
		if(!checkContainsOnlyDigits1To9(candidateSolution)) {
			return R1_VIOLATION;
		}
		
		String[][] sudokuGrid = convertToSudokuGrid(candidateSolution);
		
		printSudokuStr(candidateSolution);
		// returns 0 if the candidate solution is correct
		return VALID;
	}
	
	public static void printSudokuStr(String sudokuStr) {
		for(int i = 0; i < 81; i++) {
			if((i+1) % 3 == 0) {
				System.out.printf("[%s!",""+sudokuStr.charAt(i));
			} else {
				System.out.printf("[%s]",""+ sudokuStr.charAt(i));
			}
			
			if((i+1) % 9 == 0) {
				System.out.printf("%s","\n");
			}
		}
	}
	
	private static String[][] convertToSudokuGrid(String candidateSolution) {
		String[][] res = new String[9][9];
		int row, col;
		for(int i = 0; i < 81; i++) {
			row = i / 9;
			col = i % 9;
			res[row][col] = ""+candidateSolution.charAt(i);
		}
		
		return res;
	}
	
	private static boolean checkRows(String[][] sudokuGrid) {
		String seenDigits = "";
		
		//go through all rows
		for(int i = 0; i < 9; i++) {
			seenDigits = "";
			//test all individual rows
			for(int j = 0; j < 9; i++) {
				CharSequence digit = sudokuGrid[i][j];
				
				if(seenDigits.contains(digit)) {
					return false;
				}
				
				seenDigits += digit;
			}
		}
	}
	
	private static boolean checkContainsOnlyDigits1To9(String candidateSolution) {
		String digits = "123456789";
		for(char c: candidateSolution.toCharArray()) {
			if(digits.indexOf("" + c) == -1) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
