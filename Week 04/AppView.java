import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public void outputResult(TestResult aTestResult) {
		System.out.println("ũ�� : " + aTestResult.testSize() + "                �����ϱ� : "
				+ aTestResult.testInsertTime() + "               �ִ밪ã�� : "
				+ aTestResult.testFindMaxTime());

	}
}
