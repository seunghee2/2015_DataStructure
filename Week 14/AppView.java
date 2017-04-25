import java.util.Scanner;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public char inputCharacter() {
		System.out.print("? 해야할 일의 코드를 치시오 : ");
		return this._scanner.next().charAt(0);
	}

	public int inputNumber() {
		System.out.print("- 삽입할 정수값을 입력하시오: ");
		return this._scanner.nextInt();
	}

	public void outputAdd(Comparable anElement) {
		System.out.println(anElement + "이 정상적으로 입력 되었습니다.");

	}

	public void outputSize(int size) {
		System.out.println("- Priority Queue 에는 " + size + "개의 원소가 들어 있습니다.");

	}

	public void outputMaxValue(int maxValue) {
		System.out.println("- Priority Queue의 최대값은 " + maxValue + " 입니다.");
	}

	public void outputRemovedMax(int maxValue) {
		System.out.println("- 최대값 " + maxValue + "이 삭제되었습니다.");
	}

	public void outputElement(Comparable anElement) {
		System.out.print(anElement + " ");
	}

}
