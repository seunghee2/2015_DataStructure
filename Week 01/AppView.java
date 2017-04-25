import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;

	public AppView() { //입력받을 객체를 생성한다.
		this._scanner = new Scanner(System.in);
	}
	
	public int inputOrder() { //사용자로부터 차수를 입력받는다.
		System.out.print("마방진 차수를 입력하시오 (음수를 입력하면 종료합니다.) : ");
		return this._scanner.nextInt();
	}
	
	public void outputTitleWithOrder(int anOrder) {  //입력받은 차수를 출력한다.
		System.out.println("Magic Square Board: Order " + anOrder);
	}

	public void outputColNumber(int aColNumber) { //차수만큼의 행을 순서대로 출력한다.
		System.out.printf("[%3d]", aColNumber);
	}

	public void outputRowNumber(int aRowNumber) { //차수만큼의 열을 순서대로 출력한다.
		System.out.printf("[%3d]", aRowNumber);
	}

	public void outputCell(int anElement) { //성분들을 출력한다.
		System.out.printf("%5d", anElement);
	}

	public void outputLineNext() { 
		System.out.println();
	}

	public void outputMessage(String aMessageString) {  //마방진 계산이 불가능한 경우에 따른 메시지를 출력한다.
		System.out.println(aMessageString);
	}


}
