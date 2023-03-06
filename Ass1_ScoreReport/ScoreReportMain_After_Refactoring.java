package ScoreReport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScoreReportMain {
	private static enum Command{
		QUIT,
		ADD_STUDENT_NAME,
		ADD_STUDENT_SCORE,
		SHOW_STUDENT_REPORT,
		CLEAR_STUDENT_SCORE,
		BASE_INIT;
	}
	private static Scanner scanner = new Scanner(System.in) ;
	private List<Student> student = new ArrayList<Student>();

	public static void main(String[] args) {
		ScoreReportMain Report = new ScoreReportMain() ;

		boolean quit = false ;
		while ( ! quit ) {
			showCommand();
			Command command = getCommand();
			
			switch ( command ) {
			case QUIT: quit = true ; break ;
			case ADD_STUDENT_NAME: Report.addStudentName() ; break ;
			case ADD_STUDENT_SCORE: Report.addStudentScore() ; break ;
			case SHOW_STUDENT_REPORT: Report.ShowStudentReport() ; break ;
			case CLEAR_STUDENT_SCORE: Report.ClearScore() ; break ;
			case BASE_INIT: Report.BaseInit() ; break ;
			default: break ;
			}
		}
		
		endMessage();
	}

	private static void endMessage() {
		System.out.println("Bye");
	}
	
	private static void showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. Add student");
		System.out.println("\t 2. Add scores");
		System.out.println("\t 3. Show student report");
		System.out.println("\t 4. Clear student scores");
		System.out.println("\t 5. Input base Init");
	}

	private static Command getCommand() {
		int input_cmd = scanner.nextInt() ;
		Command command = Command.values()[input_cmd];
		return command ;
	}
	private void BaseInit() {
		Student james = new Student("James") ;
		james.getScore().add(20) ;
		james.getScore().add(10) ;

		Student brown = new Student("Brown") ;
		brown.getScore().add(30) ;
		brown.getScore().add(10) ;
		brown.getScore().add(20) ;
		brown.getScore().add(60) ;
		brown.getScore().add(50) ;

		student.add(james) ;
		student.add(brown) ;
	}
	private void ClearScore() {
		String inputStudentName = inputStudentName();
		for ( Student st : student ) {
			if ( isEqualName(inputStudentName, st)) {
				st.getScore().clear();
				System.out.println("Score cleared");
				break;
			}
		}
	}

	private String inputStudentName() {
		System.out.println("Enter student name: ");
		String inputStudentName = scanner.next() ;
		return inputStudentName;
	}

	private boolean isEqualName(String inputStudentName, Student st) {
		return st.getName().equals(inputStudentName);
	}
	private void ShowStudentReport() {
		String inputStudentName = inputStudentName();
		for ( Student st : student ) {
			if ( isEqualName(inputStudentName, st)) {
				int sum = 0 ;
				for ( Integer score: st.getScore()) {
					System.out.print(score + " ");
					sum += score ;
				}
				System.out.println("Sum: " + sum);
				break;
			}
		}
	}
	private void addStudentName() {
		String inputStudentName = inputStudentName();
		Student s = new Student(inputStudentName);
		student.add(s) ;
	}
	private void addStudentScore() {
		final int STOP = -1;
		String inputStudentName = inputStudentName();
		for ( Student st : student ) {
			if ( isEqualName(inputStudentName, st)) {
				System.out.println("Enter scores( -1 for quit): ") ;
				while ( true ) {
					int stopInputScore = scanner.nextInt() ;
					if ( stopInputScore == STOP ) break ;

					st.getScore().add(stopInputScore) ;
				}
				break;
			}
		}
	}
}