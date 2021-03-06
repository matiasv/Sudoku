package org.univoulu.tol.sqatlab.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SudokuVerifier {
	public static final int VALID = 0;
	public static final int R1_VIOLATION = -1;
	public static final int R2_VIOLATION =  -2;
	public static final int R3_VIOLATION = -3;
	public static final int R4_VIOLATION = -4;

	private static class IntPair {
		private int first;
		private int second;
		
		public IntPair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public int getFirst() { return first; }
		public int getSecond() { return second; }
	};
	
	private static HashMap<Integer,IntPair> subGridCoordinates;
	
	/*
	 *    0  1  2  3  4  5  6  7  8
	 * 0| 0  0  0  1  1  1  2  2  2  
	 * 1| 0  0  0  1  1  1  2  2  2
	 * 2| 0  0  0  1  1  1  2  2  2
	 * 3| 3  3  3  4  4  4  5  5  5
	 * 4| 3  3  3  4  4  4  5  5  5
	 * 5| 3  3  3  4  4  4  5  5  5
	 * 6| 6  6  6  7  7  7  8  8  8
	 * 7| 6  6  6  7  7  7  8  8  8
	 * 8| 6  6  6  7  7  7  8  8  8
	 */
	static {
		subGridCoordinates = new HashMap<Integer,IntPair>();
		subGridCoordinates.put(0, new IntPair(0,0));
		subGridCoordinates.put(1, new IntPair(0,3));
		subGridCoordinates.put(2,new IntPair(0,6));
		subGridCoordinates.put(3, new IntPair(3,0));
		subGridCoordinates.put(4, new IntPair(3,3));
	}
	
	
	public int verify(String candidateSolution) {
		// simple failure cases first
		if (null == candidateSolution) {
			return R1_VIOLATION;
		}

		if (candidateSolution.length() != 81) {
			return R1_VIOLATION;
		}

		// check that the candidate solution contains only digits
		// from 1 to 9
		if (!checkContainsOnlyDigits1To9(candidateSolution)) {
			return R1_VIOLATION;
		}

		String[][] sudokuGrid = convertToSudokuGrid(candidateSolution);

		printSudokuStr(candidateSolution);

		if (!checkRows(sudokuGrid)) {
			return R3_VIOLATION;
		}
		
		if(!checkCols(sudokuGrid)) {
			return R4_VIOLATION;
		}

		// returns 0 if the candidate solution is correct
		return VALID;
	}

	public static void printSudokuStr(String sudokuStr) {
		for (int i = 0; i < 81; i++) {
			if ((i + 1) % 3 == 0) {
				System.out.printf("[%s!", "" + sudokuStr.charAt(i));
			} else {
				System.out.printf("[%s]", "" + sudokuStr.charAt(i));
			}

			if ((i + 1) % 9 == 0) {
				System.out.printf("%s", "\n");
			}
		}
	}
	
	private static boolean checkSubGrids(String[][] sudokuGrid) {
		
		return false;
	}
	
	
	
	/*
	 *    0  1  2  3  4  5  6  7  8
	 * 0| 0  0  0  1  1  1  2  2  2  
	 * 1| 0  0  0  1  1  1  2  2  2
	 * 2| 0  0  0  1  1  1  2  2  2
	 * 3| 3  3  3  4  4  4  5  5  5
	 * 4| 3  3  3  4  4  4  5  5  5
	 * 5| 3  3  3  4  4  4  5  5  5
	 * 6| 6  6  6  7  7  7  8  8  8
	 * 7| 6  6  6  7  7  7  8  8  8
	 * 8| 6  6  6  7  7  7  8  8  8
	 */
	private static boolean checkSubGrid(String[][] sudokuGrid,int indx) {
		
		return false;
	}

	private static String[][] convertToSudokuGrid(String candidateSolution) {
		String[][] res = new String[9][9];
		int row, col;
		for (int i = 0; i < 81; i++) {
			row = i / 9;
			col = i % 9;
			res[row][col] = "" + candidateSolution.charAt(i);
		}

		return res;
	}

	private static boolean checkCols(String[][] sudokuGrid) {
		for (int i = 0; i < 9; i++) {
			if(!checkRowOrColumn(sudokuGrid,i,false)) {
				return false;
			}
		}

		return false;
	}

	private static boolean checkRows(String[][] sudokuGrid) {
		for (int i = 0; i < 9; i++) {
			if (!checkRowOrColumn(sudokuGrid, i, true)) {
				return false;
			}
		}

		return true;
	}

	private static boolean checkRowOrColumn(String[][] grid, int indx, boolean checkRow) {

		String[] expectedDigits = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		ArrayList<String> digits = new ArrayList<String>();

		for (int i = 0; i < 9; i++) {
			String toAdd = checkRow ? grid[indx][i] : grid[i][indx];
			digits.add(toAdd);
		}

		Collections.sort(digits);

		return Arrays.equals(digits.toArray(), expectedDigits);
	}

	private static boolean checkContainsOnlyDigits1To9(String candidateSolution) {
		String digits = "123456789";
		for (char c : candidateSolution.toCharArray()) {
			if (digits.indexOf("" + c) == -1) {
				return false;
			}
		}

		return true;
	}

}
