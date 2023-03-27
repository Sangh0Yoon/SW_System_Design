package PuzzleBuilder;

public class PuzzleBuilder {
	private Word[] words;
	private int currentNumberOfWords;

	private String name;

	public PuzzleBuilder(String name, int size) {
		this.name = name;
		words = new Word[size];
		currentNumberOfWords = 0;
	}

	public int getCurrentNubersOfWords() {
		return currentNumberOfWords;
	}
	public String getName() {
		return name;
	}
	public Word getWord(int idx) {return words[idx];}

	public boolean addWord(String putWord, int putX, int putY, int putDirections) {
		for (int i = 0; i < currentNumberOfWords; i++) {
			final boolean isAlreadyWord = words[i].getWord().compareTo(putWord) == 0;
			final boolean isSameDirections = words[i].getDirection() == putDirections;
			
			if (isAlreadyWord && isSameDirections)
				return false;
		}
		boolean failure = false;
		for (int i = 0; i < currentNumberOfWords; i++) {
			final boolean isHorizontal = words[i].getDirection() == 0;
			final boolean putHorizantal = putDirections == 0;
			
			if (isHorizontal) {
				if (putHorizantal) {
					final boolean isSameHorizantal = words[i].getYPosition() == putY;
					final boolean isIncludeXStartPosition = putX >= words[i].getXPosition() && putX <= words[i].getXPosition() + words[i].getWord().length();
					final boolean isIncludeXEndPosition = putX + putWord.length() >= words[i].getXPosition() && putX + putWord.length() <= words[i].getXPosition() + words[i].getWord().length();
					if (isSameHorizantal && (isIncludeXStartPosition || isIncludeXEndPosition)) {
						failure = true;
						break;
					}
				} else {
					final boolean isOverlapXPosition = putX >= words[i].getXPosition() && putX <= words[i].getXPosition() + words[i].getWord().length();
					final boolean isOverlapYPosition = words[i].getYPosition() >= putY && words[i].getYPosition() <= putY + putWord.length();
					if (isOverlapXPosition && isOverlapYPosition) {
						failure = true;
						break;
					}
				}
			} else {
				if (putHorizantal) {
					final boolean isOverlapYPosition = putY >= words[i].getYPosition() && putY <= words[i].getYPosition() + words[i].getWord().length();
					final boolean isOverlapXPosition = words[i].getXPosition() >= putX && words[i].getXPosition() <= putX + putWord.length();
					if (isOverlapXPosition && isOverlapYPosition) {
						failure = true;
						break;
					}
				} else {
					final boolean isSameVertical = words[i].getXPosition() == putX;
					final boolean isIncludeYStartPosition = putY >= words[i].getYPosition() && putY <= words[i].getYPosition() + words[i].getWord().length();
					final boolean isIncludeYEndPosition = putY + putWord.length() >= words[i].getYPosition() && putY + putWord.length() <= words[i].getYPosition() + words[i].getWord().length();
					if (isSameVertical && (isIncludeYStartPosition || isIncludeYEndPosition)) {
						failure = true;
						break;
					}
				}
			}
		}
		if (failure)
			return false;

		words[currentNumberOfWords].setWord(putWord);
		words[currentNumberOfWords].setXPosition(putX);
		words[currentNumberOfWords].setYPosition(putY);
		words[currentNumberOfWords].setDirection(putDirections);

		currentNumberOfWords++;
		return true;
	}

	public int getWordPosition(int coordination, String word, int dir) {
		for (int i = 0; i < currentNumberOfWords; i++) {
			final boolean isSameWord = words[i].getWord().compareTo(word) == 0;
			if (isSameWord && words[i].getDirection() == dir) {
				final boolean horizantal = coordination == 0;
				if (horizantal)
					return words[i].getXPosition();
				else
					return words[i].getYPosition();
			}
		}

		return -1;
	}

	public int getPoint() {
		int totalPoint = 0;
		for (int i = 0; i < currentNumberOfWords; i++) {
			int point;
			final boolean horizantal = words[i].getDirection() == 0;
			if (horizantal)
				point = words[i].getWord().length();
			else
				point = words[i].getWord().length() * 2;

			totalPoint += point;
		}
		return totalPoint;
	}

	public String getShortHTMLReport() {
		HTMLReport htmlReport = new HTMLReport();
		return htmlReport.getShortReport(this);
	}
	public String getFullHTMLReport() {
		HTMLReport htmlReport = new HTMLReport();
		return htmlReport.getFullReport(this);
	}
	public String getShortTextReport() {
		TextReport textReport = new TextReport();
		return textReport.getShortReport(this);
	}
	public String getFullTextReport() {
		TextReport textReport = new TextReport();
		return textReport.getFullReport(this);
	}
}
