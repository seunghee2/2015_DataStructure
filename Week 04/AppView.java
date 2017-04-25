import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public void outputResult(TestResult aTestResult) {
		System.out.println("크기 : " + aTestResult.testSize() + "                삽입하기 : "
				+ aTestResult.testInsertTime() + "               최대값찾기 : "
				+ aTestResult.testFindMaxTime());

	}
}
