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
		System.out.println("X 좌표 : " + aX);
		System.out.println("Y 좌표 : " + aY);
		System.out.println("별의 이름 : " + aStarName);
	}

	public void outputStarExistence(String aStarName, int aX, int aY) {
		if (aX == 0 && aY == 0)
			System.out.println(aStarName + " 별이 존재합니다.");

		else if (aStarName == null)
			System.out.println("( " + aX + ", " + aY + " ) 위치에 별이 존재합니다.");

	}

	public void outputNumOfStars(int aStarCollectorSize) {
		System.out.println(aStarCollectorSize + "개의 별이 존재합니다.");
	}

	public void outputMessage(String aMessageString) {
		System.out.print(aMessageString);

	}
}
