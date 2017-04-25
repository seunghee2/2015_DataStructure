public class AppController {
	private AppView _appView;
	private int[] _data;
	private DataGenerator _dataGenerator;
	private PerformanceMeasurement _pmMeasurement;
	private double _InsertionSortDuration;
	private double _QuickSortDuration;
	private double _bubbleSortDuration;
	private double _SelectionSortDuration;
	private int _sortType;

	private int _maxDataSize;
	private int _dataTerm;

	public AppController() {
		this._appView = new AppView();
		this._dataGenerator = new DataGenerator();
		this._pmMeasurement = new PerformanceMeasurement();
	}

	private void doTest(int dataSize) {
		this._InsertionSortDuration = 0;
		this._QuickSortDuration = 0;
		this._SelectionSortDuration = 0;
		this._bubbleSortDuration = 0;

		for (int i = 0; i < this._maxDataSize; i++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._InsertionSortDuration += this._pmMeasurement
					.testInsertionSort(this._data, dataSize);
		}
		this._InsertionSortDuration = this._InsertionSortDuration
				/ this._maxDataSize;

		for (int i = 0; i < this._maxDataSize; i++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._QuickSortDuration += this._pmMeasurement.testQuickSort(_data,
					dataSize);

		}
		this._QuickSortDuration = this._QuickSortDuration / this._maxDataSize;

		for (int i = 0; i < this._maxDataSize; i++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._bubbleSortDuration += this._pmMeasurement.testQuickSort(
					_data, dataSize);

		}
		this._bubbleSortDuration = this._bubbleSortDuration / this._maxDataSize;

		for (int i = 0; i < this._maxDataSize; i++) {
			this._data = this._dataGenerator.getData(dataSize);
			this._SelectionSortDuration += this._pmMeasurement.testQuickSort(
					_data, dataSize);

		}
		this._SelectionSortDuration = this._SelectionSortDuration
				/ this._maxDataSize;
	}

	public void run() {
		this.showMessage(MessageiD.Notice_StartProgram);
		this._sortType = 0;

		this._maxDataSize = this._appView.inputMaxDataSize();
		this._dataTerm = this._appView.inputDataTerm();

		while (this._sortType != 4) {
			this.showMessage(MessageiD.Notice_Menu);
			this._sortType = this._appView.inputSortType();
			if (this._sortType == 1) {
				this._dataGenerator.generateSequentialData(this._maxDataSize);
				this.showMessage(MessageiD.Notice_SequentialData);
			} else if (this._sortType == 2) {
				this._dataGenerator.generateSequentialData(this._maxDataSize);
				this.showMessage(MessageiD.Notice_ReverseData);
			} else if (this._sortType == 3) {
				this._dataGenerator.generateSequentialData(this._maxDataSize);
				this.showMessage(MessageiD.Notice_RandomData);
			} else if (this._sortType == 4) {
				break;
			} else {
				this.showMessage(MessageiD.Error_WrongMenu);
				continue;
			}
			this.showMessage(MessageiD.Notice_ShowTitle);

			this.doTest(this._dataTerm);

			for (int dataSize = this._dataTerm; dataSize <= this._maxDataSize; 
					dataSize += this._dataTerm) {
				this.doTest(dataSize);
				this._appView.outputResult(dataSize, _InsertionSortDuration,
						_QuickSortDuration, _SelectionSortDuration,
						_bubbleSortDuration);
			}
		}
		this.showMessage(MessageiD.Notice_EndProgram);
	}

	private void showMessage(MessageiD aMessageID) {
		switch (aMessageID) {
		case Notice_StartProgram:
			System.out.println("< 정렬에 따른 실행 성능 차이 알아보기 >");
			break;
		case Notice_Menu:
			System.out.println("[1] sequential Data");
			System.out.println("[2] Reverse Data");
			System.out.println("[3] Random Data");
			System.out.println("[4] End");
			break;
		case Notice_SequentialData:
			System.out.println("=== SEQUENTIAL DATA ===");
			break;
		case Notice_ReverseData:
			System.out.println("=== REVERSE DATA ===");
			break;
		case Notice_RandomData:
			System.out.println("=== RANDOM DATA ===");
			break;
		case Notice_ShowTitle:
			System.out
					.println("DataSize\tInsertion\tQuick\t\tSelection\t\tBubble");
			break;
		case Notice_EndProgram:
			System.out.println("< 성능 측정을 종료합니다 >");
			break;
		default:
			System.out.println("ERROR");

		}

	}

}
