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
		
		// returns 1 if the candidate solution is correct
		return 0;
	}
	
	
}
