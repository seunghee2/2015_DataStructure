import java.util.Random;

public class PerformanceMeasurement {
	private static final int MaxTestSize = 10000;
	private static final int NumOfTests = 5;
	private static final int FirstTestSize = 1000;
	private static final int SizeIncremenet = 1000;

	private int _maxTestSize;
	private int _numOfTests;
	private int _firstTestSize;
	private int _sizeIncrement;
	private long[] _testSizes;
	private long[] _data;

	public PerformanceMeasurement() {
		this._maxTestSize = MaxTestSize;		
		this._numOfTests = NumOfTests;
		this._firstTestSize = this.FirstTestSize;
		this._sizeIncrement = this.SizeIncremenet;

		this._data = new long[MaxTestSize];
		this._testSizes = new long[NumOfTests];

		int i = 0;
		while (i < this._numOfTests) {
			this._testSizes[i] = this._firstTestSize + this._sizeIncrement * i;
			i++;
		}
	}

	public PerformanceMeasurement(int aMaxTestSize, int aNumOfTests,
			int aFirstTestSize, int aSizeIncrement) {
		this._maxTestSize = aMaxTestSize;
		this._numOfTests = aNumOfTests;
		this._firstTestSize = aFirstTestSize;
		this._sizeIncrement = aSizeIncrement;
	}

	public void generateData() {
		int i = 0;
		Random random = new Random();
		while (i < this._maxTestSize) {
			this._data[i] = random.nextInt(this._maxTestSize);
			i++;
		}
	}

	public int numOfTests() {
		return this._numOfTests;
	}

	public TestResult unsortedArrayBag(long testCount) {
		UnsortedArrayBag bag;
		long max;
		long testSize;
		long timeForAdd, timeForMax;
		long start, end;
		int i;

		testSize = this._testSizes[(int) testCount];
		bag = new UnsortedArrayBag(testSize);

		i = 0;
		timeForAdd = 0;
		timeForMax = 0;
		while (i < testSize) {
			start = System.nanoTime();
			Coin aCoin = new Coin(this._data[i]);
			bag.add(aCoin);
			end = System.nanoTime();
			timeForAdd += (double) (end - start);

			start = System.nanoTime();
			max = bag.maxCoinValues();
			end = System.nanoTime();
			timeForMax += (double) (end - start);

			i++;

		}
		return new TestResult(testSize, timeForAdd, timeForMax);

	}

	public TestResult sortedArrayBag(long testCount) {
		SortedArrayBag bag;
		long max;
		long testSize;
		long timeForAdd, timeForMax;
		long start, end;
		int i;

		testSize = this._testSizes[(int) testCount];
		bag = new SortedArrayBag(testSize);

		i = 0;
		timeForAdd = 0;
		timeForMax = 0;
		while (i < testSize) {
			start = System.nanoTime();
			Coin aCoin = new Coin(this._data[i]);

			bag.add(aCoin);
			end = System.nanoTime();
			timeForAdd += (double) (end - start);

			start = System.nanoTime();
			max = bag.maxCoinValues();
			end = System.nanoTime();
			timeForMax += (double) (end - start);

			i++;

		}
		return new TestResult(testSize, timeForAdd, timeForMax);

	}

	public TestResult unsortedLinkedArrayBag(long testCount) {
		UnsortedLinkedArrayBag bag;
		long max;
		long testSize;
		long timeForAdd, timeForMax;
		long start, end;
		int i;

		testSize = this._testSizes[(int) testCount];
		bag = new UnsortedLinkedArrayBag();

		i = 0;
		timeForAdd = 0;
		timeForMax = 0;
		while (i < testSize) {
			start = System.nanoTime();
			Coin aCoin = new Coin(this._data[i]);

			bag.add(aCoin);
			end = System.nanoTime();
			timeForAdd += (double) (end - start);

			start = System.nanoTime();
			max = bag.maxCoinValue();
			end = System.nanoTime();
			timeForMax += (double) (end - start);

			i++;

		}
		return new TestResult(testSize, timeForAdd, timeForMax);
	}

	public TestResult sortedLinkedArrayBag(long testCount) {
		SortedLinkedArrayBag bag;
		long max;
		long testSize;
		long timeForAdd, timeForMax;
		long start, end;
		int i;

		testSize = this._testSizes[(int) testCount];
		bag = new SortedLinkedArrayBag();

		i = 0;
		timeForAdd = 0;
		timeForMax = 0;
		while (i < testSize) {
			start = System.nanoTime();
			Coin aCoin = new Coin(this._data[i]);

			bag.add(aCoin);
			end = System.nanoTime();
			timeForAdd += (double) (end - start);

			start = System.nanoTime();
			max = bag.maxCoinValue();
			end = System.nanoTime();
			timeForMax += (double) (end - start);
			i++;
		}
		return new TestResult(testSize, timeForAdd, timeForMax);
	}
}
