package PuzzleBuilder;

public class HTMLReport extends Report{
	public String headerString(String name) {
		return "<H1> Report on Puzzle <EM> " + name + "</EM></H1>\n";
	}
	public String eachWordString(Word aWord, int point) {
		return "\tWord: <B>" + aWord.getWord() + "\tPosition: [" + aWord.getXPosition() +
				", " + aWord.getYPosition() + "]" + "\tDir: " + aWord.getDirection()
				+ " </B> Point: <B> " + point + "</B>\n";
	}
	public String footerString(int point) {
		return "<HR> Total Point: <B>" + point + "</B><P>\n";
	}
}
