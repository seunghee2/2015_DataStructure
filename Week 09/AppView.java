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
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		return this.inputString().charAt(0);
	}

	public void outputAdd(char anElement) {
		System.out.println("[EnQueue] ���Ե� ���Ҵ� " + anElement + " �Դϴ�. ");

	}

	public void outputElement(char anElement) {
		System.out.print(" " + anElement + " ");
	}

	public void outputFrontElement(char anElement) {
		System.out.println("[Front] �� �� ���Ҵ� " + anElement + "�Դϴ�. ");
	}

	public void outputQueueSize(int aQueueSize) {
		System.out.println("[Size] ť���� ���� " + aQueueSize + "���� ���Ұ� �ֽ��ϴ�.");
	}

	public void outputRemove(char anElement) {
		System.out.println("[DeQueue] ������ ���Ҵ� " + anElement + "�Դϴ�.");

	}

	public void outputRemoveN(int aNumOfCharsToBeRemoved) {
		System.out.println("[RemoveN] " + aNumOfCharsToBeRemoved
				+ "���� ���Ҹ� �����Ϸ��� �մϴ�.");
	}

	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars,
			int aNumOfAddedChars) {
		System.out.println("... . .�Էµ� ���ڴ� ��� " + aNumOfInputChars + " �� �Դϴ�.");
		System.out.println("... . .���� ó���� ���ڴ� "
				+ (aNumOfInputChars - aNumOfIgnoredChars) + " �� �Դϴ�.");
		System.out.println("... . .���õ� ���ڴ� " + aNumOfIgnoredChars + " �� �Դϴ�.");
		System.out.println("... . .���Ե� ���ڴ� " + aNumOfAddedChars + " �� �Դϴ�.");
		System.out.println();

	}
}
