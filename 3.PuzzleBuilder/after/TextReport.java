package PuzzleBuilder;

public class TextReport extends Report{
	public String headerString(String name) {
		return "Report on Puzzle" + name + "\n";
	}
	public String eachWordString(Word aWord, int point) {
		return "\tWord: " + aWord.getWord() + "\tPosition: [" + aWord.getXPosition() +
				", " + aWord.getYPosition() + "]" + "\tDir: " + aWord.getDirection()
				+ "Point:" + point + "\n";
	}
	public String footerString(int point) {
		return "Total Point:" + point + "\n";
	}
}
