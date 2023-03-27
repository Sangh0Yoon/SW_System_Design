package PuzzleBuilder;

public abstract class Report {
	public String getFullReport(PuzzleBuilder puzzle) {
		String result;
		int point = 0;
		result = headerString(puzzle.getName());
		for(int i=0;i<puzzle.getCurrentNubersOfWords();i++) {
			if (puzzle.getWord(i).getDirection() == 0)
				point = puzzle.getWord(i).getWord().length();
			else
				point = puzzle.getWord(i).getWord().length() * 2;
			result += eachWordString(puzzle.getWord(i), point);
		}
		result += footerString(puzzle.getPoint());
		
		return result;
	}
	
	public String getShortReport(PuzzleBuilder puzzle) {
		String result;
		result = headerString(puzzle.getName());
		result += footerString(puzzle.getPoint());
		
		return result;
	}
	
	public abstract String headerString(String name);
	public abstract String eachWordString(Word aWord, int point);
	public abstract String footerString(int point);
}
