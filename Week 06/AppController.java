public class AppController {
	private AppView _appView;
	private Ban _ban;

	public AppController() {
		this._appView = new AppView();

	}

	private boolean inputAndStoreStudents() {
		this.showMessage(MessageID.Notice_StartProgram);
		int score;
		boolean storingAStudentWasSuccessful = true;
		this._ban = new Ban();
		while (storingAStudentWasSuccessful
				&& this._appView.inputDoesContinueToInputNextStudent()) {
			score = this._appView.inputScore();
			if (score < 0 || score > 100)
				this.showMessage(MessageID.Error_InvalidScore);
			else {
				Student aStudent = new Student(score);
				this._ban.add(aStudent);
			}
		}
		this.showMessage(MessageID.Notice_EndMenu);
		return storingAStudentWasSuccessful;

	}

	private void showStatistics() {
		this._appView.outputAverageScore(this._ban.averageScore());
		this._appView.outputNumberOfStudentsAboveAverage(this._ban
				.numberOfStudentsAboveAverage());
		this._appView.outputMaxScore(this._ban.maxScore());
		this._appView.outputMinScore(this._ban.minScore());

		GradeCounter gradeCounter = this._ban.countGrades();
		this._appView.outputGradeCountFor('A', gradeCounter.numberOfA());
		this._appView.outputGradeCountFor('B', gradeCounter.numberOfB());
		this._appView.outputGradeCountFor('C', gradeCounter.numberOfC());
		this._appView.outputGradeCountFor('D', gradeCounter.numberOfD());
		this._appView.outputGradeCountFor('F', gradeCounter.numberOfF());
	}

	private void showStudentsSortedByScore() {
		this.showMessage(MessageID.Show_SortedStudentList);
		for (int index = 0; index < this._ban.size(); index++) {
			this._appView.outputStudentInfo(this._ban.elementAt(index).score());
		}
	}

	public void run() {

		this.inputAndStoreStudents();
		if (this._ban.isEmpty() == true)
			this.showMessage(MessageID.Error_Input);
		else {
			this.showStatistics();
			this._ban.sortStudentsByScore();
			this.showStudentsSortedByScore();
		}
		this.showMessage(MessageID.Notice_EndProgram);

	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("<< 성적 처리를 시작합니다 >>");
			break;
		case Notice_EndProgram:
			System.out.println("<< 성적 처리를 종료합니다 >>");
			break;
		case Notice_StartMenu:
			System.out.print("- 점수를 입력하시오 : ");
			break;
		case Notice_EndMenu:
			System.out.println("[ 성적 입력을 종료합니다. ]");
			break;
		case Error_WrongMenu:
			System.out.println("잘못된 입력입니다.");
			break;
		case Show_SortedStudentList:
			System.out.println("학생들의 성적순 목록입니다.");
			break;
		case Error_InvalidScore:
			System.out.println("ERROR : 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.");
			break;
		case Error_Input:
			System.out.println("잘못된 입력입니다.");
			break;

		}

	}

}
