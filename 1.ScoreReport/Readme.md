# 🎉ScoreReport
----------------
## Student.java / Student_After_Refactoring.java
+ 함수의 이름만 명확하게 Renaming 하였음.
----------------
## ScoreReportMain.java / ScoreReportMain_After_Refactoring.java
+ 명확하지 않은 변수 및 함수의 이름을 명확하게 Renaming 하였음.
+ switch 문의 조건을 Polymorphism 하게 Replace 하였음.
+ 학생이름을 입력받는 코드 부분이 중복되어 모듈화 하였음.
+ if문 안에 데이터와 입력값을 비교하는 내용이 중복되고 알아보기 힘들어서 isEqualName으로 모듈화 및 Reanaming 하였음.
+ add 라는 함수의 목적이 여러개여서 단일 목적으로 substract 하여 분리하였음.
+ shwcmd에서 Extract method 하여 getCommand를 분리하였음.
## ScoreReportMain_After_Refactoring.java 추가사항
+ StudentList 를 Rename 하였음.
+ ShowStudentReport()에서 계산하는 부분 Extract Method하여 sumOfScores 함수 만듬.
+ addStudentScore 에서 입력 중단하는 if문 부분을 Extract local variable하여 STOP으로 바꿈.
