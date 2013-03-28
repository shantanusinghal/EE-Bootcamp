package ee.bootcamp.games;

public class TwoDimensionalBoard {
	
	private String[][] positions;
	
	TwoDimensionalBoard(int size) {
		positions = new String[size][size];		
	}
	
	public void markCross (int x, int y) {
		positions[x][y] = "X";
	}
	
	public void markCircle (int x, int y) {
		positions[x][y] = "O";
	}

	public void showBoard() {
		
	}
}
