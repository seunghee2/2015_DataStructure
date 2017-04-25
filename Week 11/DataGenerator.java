public class DataGenerator {
	private int[] _dataArray;
	private int _dataSize;

	public DataGenerator() {
		this._dataSize = 0;
		this._dataArray = new int[this._dataSize];
	}

	public void generateSequentialData(int size) {
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for (int i = 1; i < size; i++)
			this._dataArray[i] = i;
	}

	public void generateReverseData(int size) {
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for (int i = 1; i < size; i++)
			this._dataArray[i] = size - i;
	}

	public void generateRandomData(int size) {
		this._dataArray = new int[size];
		this._dataArray[0] = -1;
		this._dataSize = size;
		for (int i = 1; i < size; i++)
			this._dataArray[i] = (int) (Math.random() * this._dataSize);
	}

	public int[] getData(int size) {
		int[] copyArray = new int[size];
		for (int i = 0; i < size; i++)
			copyArray[i] = this._dataArray[i];

		return copyArray;
	}
}
