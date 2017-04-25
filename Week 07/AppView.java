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
		System.out.print("- 문자를 입력하시오 : ");
		return this.inputString().charAt(0);
	}

	public void outputAddedElement(char anElement) {
		System.out.println("[Push] 삽입된 원소는 '" + anElement + "' 입니다.");
	}

	public void outputStackElement(char anElement) {
		System.out.print(" " + anElement + " ");
	}

	public void outputTopElement(char anElement) {
		System.out.println("[Top] Top 원소는 '" + anElement + "' 입니다.");
	}

	public void outputStackSize(int aStackSize) {
		System.out.println("[Size] 스택에는 현재 " + aStackSize + "개의 원소가 있습니다.");
	}

	public void outputRemove(char anElement) {
		System.out.println("[Pop] 삭제된 원소는 '" + anElement + "'입니다.");
	}

	public void outputRemoveN(int aNumOfCharsToBeRemoved) {
		System.out.println("[Pop] "+aNumOfCharsToBeRemoved+"개 원소를 삭제하려고 합니다.");
	
	}

	public void outputResult(int aNumOfInputChars, int aNumOfIgnoredChars,
			int aNumOfAddedChars) {
		System.out.println("... . . 입력된 문자는 총 " + aNumOfInputChars + "개 입니다.");
		System.out.println("... . . 정상 처리된 문자는 "
				+ (aNumOfInputChars - aNumOfIgnoredChars) + "개 입니다.");
		System.out.println("... . . 무시된 문자는 " + aNumOfIgnoredChars + "개 입니다.");
		System.out.println("... . . 삽입된 문자는 " + aNumOfAddedChars + "개 입니다.");
	}


}
