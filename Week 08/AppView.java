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
		System.out.print("> ������ �Է��Ͻÿ� : ");
		return this.inputString();
	}

	public void outputResult(double aValue) {
		System.out.println("[������] " + aValue);
		System.out.println();
	}

	public void outputPostfix(String aPostfix) {
		System.out.println();
		System.out.println("[Postfix] " + aPostfix);
	}

}
