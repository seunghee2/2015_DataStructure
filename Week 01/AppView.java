import java.util.Scanner;

public class AppView {
	
	private Scanner _scanner;

	public AppView() { //�Է¹��� ��ü�� �����Ѵ�.
		this._scanner = new Scanner(System.in);
	}
	
	public int inputOrder() { //����ڷκ��� ������ �Է¹޴´�.
		System.out.print("������ ������ �Է��Ͻÿ� (������ �Է��ϸ� �����մϴ�.) : ");
		return this._scanner.nextInt();
	}
	
	public void outputTitleWithOrder(int anOrder) {  //�Է¹��� ������ ����Ѵ�.
		System.out.println("Magic Square Board: Order " + anOrder);
	}

	public void outputColNumber(int aColNumber) { //������ŭ�� ���� ������� ����Ѵ�.
		System.out.printf("[%3d]", aColNumber);
	}

	public void outputRowNumber(int aRowNumber) { //������ŭ�� ���� ������� ����Ѵ�.
		System.out.printf("[%3d]", aRowNumber);
	}

	public void outputCell(int anElement) { //���е��� ����Ѵ�.
		System.out.printf("%5d", anElement);
	}

	public void outputLineNext() { 
		System.out.println();
	}

	public void outputMessage(String aMessageString) {  //������ ����� �Ұ����� ��쿡 ���� �޽����� ����Ѵ�.
		System.out.println(aMessageString);
	}


}
