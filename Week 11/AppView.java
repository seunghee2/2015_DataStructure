import java.util.Scanner;

public class AppView {
	private Scanner _scanner;

	public AppView() {
		this._scanner = new Scanner(System.in);
	}

	public int inputInt() {
		return this._scanner.nextInt();
	}

	public int inputMaxDataSize() {
		System.out.print("Insert Max Data Size >> ");
		return this.inputInt();
	}

	public int inputDataTerm() {
		System.out.print("Insert Data Term >> ");
		return this.inputInt();
	}

	public int inputSortType() {
		System.out.print("Select a Sort >> ");
		return this.inputInt();
	}

	public void outputResult(int dataSize, double insertionSortDuration,
			double quickSortDuration, double selectionSortDuration,
			double bubbleSortDuration) {
		System.out
				.println(dataSize + "\t\t" + (int) insertionSortDuration + "\t\t"
						+ (int) quickSortDuration + "\t\t"
						+ (int) selectionSortDuration + "\t\t\t"
						+ (int) bubbleSortDuration);

	}
}
