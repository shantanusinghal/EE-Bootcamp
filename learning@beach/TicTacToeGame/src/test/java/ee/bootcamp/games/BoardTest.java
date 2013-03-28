package ee.bootcamp.games;

import org.junit.Test;

public class BoardTest {

	@Test
	public void itMarksCrossesAndCircles() {

		TwoDimensionalBoard board = new TwoDimensionalBoard(3);
		board.markCircle(1, 2);
		board.markCross(2, 2);
		
		board.showBoard();
	}

}
