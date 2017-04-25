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

	public void outputStar(String aStarName, int aX, int aY) {
		System.out.println("X ��ǥ : " + aX);
		System.out.println("Y ��ǥ : " + aY);
		System.out.println("���� �̸� : " + aStarName);
	}

	public void outputStarExistence(String aStarName, int aX, int aY) {
		if (aX == 0 && aY == 0)
			System.out.println(aStarName + " ���� �����մϴ�.");

		else if (aStarName == null)
			System.out.println("( " + aX + ", " + aY + " ) ��ġ�� ���� �����մϴ�.");

	}

	public void outputNumOfStars(int aStarCollectorSize) {
		System.out.println(aStarCollectorSize + "���� ���� �����մϴ�.");
	}

	public void outputMessage(String aMessageString) {
		System.out.print(aMessageString);

	}
}
