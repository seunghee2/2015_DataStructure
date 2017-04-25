import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public String inputString() {
		return this._scanner.next();
	}

	public char inputCharacter() {
		System.out.print("> ���ڸ� �Է��Ͻÿ� : ");
		return this._scanner.next().charAt(0);
	}

	public int inputNumber() {
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		return this._scanner.nextInt();
	}

	public void outputSize(int size) {
		System.out.println("[Length] ����Ʈ���� ���� "+size+"���� �ֽ��ϴ�.");
	}

	public void outputAdd(Comparable anElement) {
		System.out.println("[Insert] ���Ե� ���Ҵ� "+anElement+"�Դϴ�. ");
	}

	public void outputRemove(Comparable anElement) {
		System.out.println("[Delete] ������ ���Ҵ� "+anElement+"�Դϴ�. ");
	}

	public void outputElement(Comparable anElement) {
		System.out.print(anElement+" ");
	}
}
