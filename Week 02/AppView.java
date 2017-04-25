import java.util.*;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public int inputInt() {
		int _order = this._scanner.nextInt();
		return _order;
	}

	public void outputResult(int aTotalCoinSize, int aMaxCoinValue,
			int aSumOfCoinValue) {
		System.out.println("�� ���� : " + aTotalCoinSize);
		System.out.println("���� ū ���� : " + aMaxCoinValue);
		System.out.println("������ �� : " + aSumOfCoinValue);
	}

	public void outputSearch(int aSearchValue, int aSearchedSize) {
		
		System.out.println(aSearchValue + "������ " + aSearchedSize + "�� �����մϴ�.");
	}

	public void outputMessage(String aMessageString) {
		System.out.print(aMessageString);
	}

}
