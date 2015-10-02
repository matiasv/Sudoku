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
		
		
		// returns 0 if the candidate solution is correct
		return 0;
	}
	
	private static boolean checkContainsOnlyDigits1To9(String candidateSolution) {
		String digits = "0123456789";
		for(char c: candidateSolution.toCharArray()) {
			if(digits.indexOf(c) == -1) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
