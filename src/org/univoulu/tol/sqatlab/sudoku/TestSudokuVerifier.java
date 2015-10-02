package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

public class TestSudokuVerifier extends TestCase {
	private SudokuVerifier verifier;

	@Override
	protected void setUp() throws Exception {
		verifier = new SudokuVerifier();
	}


	@Test
	public void testSudokuVerifyNullString() {
		String nullStr = null;
		int res = verifier.verify(nullStr);
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
	}
	
	@Test
	public void testSudokuVerifyLength() {
		int res;
		String empty = "";
		res = verifier.verify(empty);
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
		
		//boundary case: len is 80
		String sudokuStrLen80 = "123456789123456789123456789123456789123456789123456789"
		+ "123456789" + "123456789" + "12345678";
				
		res = verifier.verify(sudokuStrLen80);
		
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
		
		//boundary case: len is 82
		String sudokuStrLen82 = "123456789123456789123456789123456789123456789123456789"
				+ "123456789" + "123456789" + "1234567891";
		
		res = verifier.verify(sudokuStrLen80);
		
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
	}
	
	@Test
	public void testSudokuVerifyNonDigitInput() {
		String invalidStr1 = "123456789123456789123456789123456789123456789123456789"
				+ "123456789" + "123456789}" + "a2345678";
		
		int res = verifier.verify(invalidStr1);
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
		
		String invalidStr2 = "123456789123456789123456789123456789123456789123456789"
				+ "123456789" + "123456789" + "120456789";
		
		assertEquals(invalidStr2.length(),81);
		
		res = verifier.verify(invalidStr2);
		
		assertEquals(res,SudokuVerifier.R1_VIOLATION);
	}
	
	@Test
	public void testSudokuInvalidRows() {
		String invalidSudoku = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
	}

}
