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
		assertEquals(res,0);
	}
	
	@Test
	public void testSudokuVerifyEmptyString() {
		String empty = "";
	}

}
