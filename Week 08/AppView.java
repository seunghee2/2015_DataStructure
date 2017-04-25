import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public String inputString() {
		return this._scanner.nextLine();
	}

	public String inputExpression() {
		System.out.print("> 수식을 입력하시오 : ");
		return this.inputString();
	}

	public void outputResult(double aValue) {
		System.out.println("[최종값] " + aValue);
		System.out.println();
	}

	public void outputPostfix(String aPostfix) {
		System.out.println();
		System.out.println("[Postfix] " + aPostfix);
	}

}
