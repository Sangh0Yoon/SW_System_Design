# ๐ScoreReport
----------------
## Student.java / Student_After_Refactoring.java
+ ํจ์์ ์ด๋ฆ๋ง ๋ชํํ๊ฒ Renaming ํ์์.
----------------
## ScoreReportMain.java / ScoreReportMain_After_Refactoring.java
+ ๋ชํํ์ง ์์ ๋ณ์ ๋ฐ ํจ์์ ์ด๋ฆ์ ๋ชํํ๊ฒ Renaming ํ์์.
+ switch ๋ฌธ์ ์กฐ๊ฑด์ Polymorphism ํ๊ฒ Replace ํ์์.
+ ํ์์ด๋ฆ์ ์๋ ฅ๋ฐ๋ ์ฝ๋ ๋ถ๋ถ์ด ์ค๋ณต๋์ด ๋ชจ๋ํ ํ์์.
+ if๋ฌธ ์์ ๋ฐ์ดํฐ์ ์๋ ฅ๊ฐ์ ๋น๊ตํ๋ ๋ด์ฉ์ด ์ค๋ณต๋๊ณ  ์์๋ณด๊ธฐ ํ๋ค์ด์ isEqualName์ผ๋ก ๋ชจ๋ํ ๋ฐ Reanaming ํ์์.
+ add ๋ผ๋ ํจ์์ ๋ชฉ์ ์ด ์ฌ๋ฌ๊ฐ์ฌ์ ๋จ์ผ ๋ชฉ์ ์ผ๋ก substract ํ์ฌ ๋ถ๋ฆฌํ์์.
+ shwcmd์์ Extract method ํ์ฌ getCommand๋ฅผ ๋ถ๋ฆฌํ์์.
## ScoreReportMain_After_Refactoring.java ์ถ๊ฐ์ฌํญ
+ StudentList ๋ฅผ Rename ํ์์.
+ ShowStudentReport()์์ ๊ณ์ฐํ๋ ๋ถ๋ถ Extract Methodํ์ฌ sumOfScores ํจ์ ๋ง๋ฌ.
+ addStudentScore ์์ ์๋ ฅ ์ค๋จํ๋ if๋ฌธ ๋ถ๋ถ์ Extract local variableํ์ฌ STOP์ผ๋ก ๋ฐ๊ฟ.
