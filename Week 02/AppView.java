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
		System.out.println("총 코인 : " + aTotalCoinSize);
		System.out.println("가장 큰 코인 : " + aMaxCoinValue);
		System.out.println("코인의 합 : " + aSumOfCoinValue);
	}

	public void outputSearch(int aSearchValue, int aSearchedSize) {
		
		System.out.println(aSearchValue + "코인은 " + aSearchedSize + "개 존재합니다.");
	}

	public void outputMessage(String aMessageString) {
		System.out.print(aMessageString);
	}

}
