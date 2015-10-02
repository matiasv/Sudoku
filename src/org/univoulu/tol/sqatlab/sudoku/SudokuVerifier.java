package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		//simple failure cases first
		if(null == candidateSolution) {
			return 0;
		} 
		
		if(candidateSolution.length() != 81) {
			return 0;
		}
		
		// returns 1 if the candidate solution is correct
		return 0;
	}
	
	
}
