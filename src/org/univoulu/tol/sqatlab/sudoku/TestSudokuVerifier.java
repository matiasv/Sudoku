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
		assertEquals(res,0);
		
		//boundary case: len is 80
		String sudokuStrLen80 = "123456789123456789123456789123456789123456789123456789 "
		+ "123456789" + "123456789" + "12345678";
		
		res = verifier.verify(sudokuStrLen80);
		
		assertEquals(res,0);
		
		//boundary case: len is 82
	}

}
