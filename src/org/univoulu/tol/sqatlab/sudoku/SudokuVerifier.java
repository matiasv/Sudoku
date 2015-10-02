package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {
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
		
		// returns 0 if the candidate solution is correct
		return 0;
	}
	
	public static void printSudokuStr(String sudokuStr) {
		for(int i = 0; i < 81; i++) {
			
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
