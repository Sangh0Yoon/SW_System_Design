package PuzzleBuilder;

public class Word {
	private String word;
	private int xPosition;
	private int yPosition;
	private int directions;
	
	public String getWord() {
		return word;
	}
	public int getXPosition(){
		return xPosition;
	}
	public int getYPosition(){
		return yPosition;
	}
	public int getDirection(){
		return directions;
	}
	public void setWord(String _word) {
		word = _word;
	}
	public void setXPosition(int _xPosition) {
		xPosition = _xPosition;
	}
	public void setYPosition(int _yPosition) {
		yPosition = _yPosition;
	}
	public void setDirection(int _direction) {
		directions = _direction;
	}
}
