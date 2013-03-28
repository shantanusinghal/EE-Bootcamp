package ee.bootcamp.games;


public class ThreeDimensionalBoard {

	private TwoDimensionalBoard[] positions;
	
	ThreeDimensionalBoard(int size) {
		positions = new TwoDimensionalBoard[size];
		for (TwoDimensionalBoard position : positions) {
			position = new TwoDimensionalBoard(size);
		}
	}
	
	public void markCross (int x, int y, int z) {
	}
	
	public void markCircle (int x, int y, int z) {
	}

	public void showBoard() {
		
	}
}
