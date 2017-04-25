import java.util.*;

public class AppView {

	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public int inputInt() {
		return this._scanner.nextInt();
	}

	public String inputString() {
		return this._scanner.next();
	}

	public char inputCharacter() {
		System.out.print("- ���ڸ� �Է��Ͻÿ� : ");
		return this.inputString().charAt(0);
	}

	public void outputAddedElement(char anElement) {
		System.out.println("[Push] ���Ե� ���Ҵ� '" + anElement + "' �Դϴ�.");
	}

	public void outputStackElement(char anElement) {
		System.out.print(" " + anElement + " ");
	}

	public void outputTopElement(char anElement) {
		System.out.println("[Top] Top ���Ҵ� '" + anElement + "' �Դϴ�.");
	}

	public void outputStackSize(int aStackSize) {
		System.out.println("[Size] ���ÿ��� ���� " + aStackSize + "���� ���Ұ� �ֽ��ϴ�.");
	}

	public void outputRemove(char anElement) {
		System.out.println("[Pop] ������ ���Ҵ� '" + anElement + "'�Դϴ�.");
	}

	public void outputRemoveN(int aNumOfCharsToBeRemoved) {
		System.out.println("[Pop] "+aNumOfCharsToBeRemoved+"�� ���Ҹ� �����Ϸ��� �մϴ�.");
	
	}

	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars,
			int aNumOfAddedChars) {
		System.out.println("... . . �Էµ� ���ڴ� �� " + aNumOfInputChars + "�� �Դϴ�.");
		System.out.println("... . . ���� ó���� ���ڴ� "
				+ (aNumOfInputChars - aNumOfIgnoredChars) + "�� �Դϴ�.");
		System.out.println("... . . ���õ� ���ڴ� " + aNumOfIgnoredChars + "�� �Դϴ�.");
		System.out.println("... . . ���Ե� ���ڴ� " + aNumOfAddedChars + "�� �Դϴ�.");
	}


}
