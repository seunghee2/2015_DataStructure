public class AppController {
	private AppView _appView;
	private PerformanceMeasurement _pml;

	public AppController() {
		this._appView = new AppView();
	}

	private void testUnsortedArrayBag() {
		this.showMessage(MessageID.Notice_UnsortedArrayStart);
		long testCount = 0;
		while (testCount < this._pml.numOfTests()) {
			TestResult testResult = this._pml.unsortedArrayBag(testCount);
			this._appView.outputResult(testResult);
			testCount++;
		}
	}

	private void testSortedArrayBag() {
		this.showMessage(MessageID.Notice_SortedArrayStart);
		long testCount = 0;
		while (testCount < this._pml.numOfTests()) {
			TestResult testResult = this._pml.sortedArrayBag(testCount);
			this._appView.outputResult(testResult);
			testCount++;
		}
	}

	private void testUnsortedLinkedArrayBag() {
		this.showMessage(MessageID.Notice_UnsortedLinkedStart);
		long testCount = 0;
		while (testCount < this._pml.numOfTests()) {
			TestResult testResult = this._pml.unsortedLinkedArrayBag(testCount);
			this._appView.outputResult(testResult);
			testCount++;
		}

	}

	private void testSortedLinkedArrayBag() {
		this.showMessage(MessageID.Notice_SortedLinkedStart);
		long testCount = 0;
		while (testCount < this._pml.numOfTests()) {
			TestResult testResult = this._pml.sortedLinkedArrayBag(testCount);
			this._appView.outputResult(testResult);
			testCount++;
		}
	}

	public void run() {
		this._pml = new PerformanceMeasurement();
		this.showMessage(MessageID.Notice_StartProgram);
		this._pml.generateData();
		this.testUnsortedArrayBag();
		this.testSortedArrayBag();
		this.testUnsortedLinkedArrayBag();
		this.testSortedLinkedArrayBag();
		this.showMessage(MessageID.Notice_EndProgram);
	}

	private void showMessage(MessageID aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("< List의 구현에 따른 실행 성능 차이 알아보기 >");
			break;
		case Notice_EndProgram:
			System.out.println("<성능 측정을 종료합니다>");
			break;
		case Notice_UnsortedArrayStart:
			System.out.println("[Unsorted Array]");
			break;
		case Notice_SortedArrayStart:
			System.out.println("[Sorted Array]");
			break;
		case Notice_UnsortedLinkedStart:
			System.out.println("[Unsorted LinkedArray]");
			break;
		case Notice_SortedLinkedStart:
			System.out.println("[Sorted LinkedArray]");
			break;
		default:
			break;
		}
	}
}
