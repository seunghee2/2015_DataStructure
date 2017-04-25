public class Ban {
	private static final int DEFAULT_MAX_SIZE = 100;
	private int _maxSize;
	private int _size;
	private Student[] _elements;

	public Ban() {
		this._maxSize = DEFAULT_MAX_SIZE;
		this._size = 0;
		this._elements = new Student[this._maxSize];

	}

	public Ban(int givenMaxNumOfStudents) {
		this._maxSize = givenMaxNumOfStudents;
		this._size = 0;
		this._elements = new Student[this._maxSize];

	}

	public int maxSize() {
		return this._maxSize;
	}

	public int size() {
		return this._size;
	}

	public boolean isEmpty() {
		if (this._size == 0)
			return true;
		else
			return false;

	}

	public boolean isFull() {
		if (this._size >= this._maxSize)
			return true;
		else
			return false;

	}

	public boolean add(Student aScore) {
		if (this.isFull() == true)
			return false;
		else {
			this._elements[this._size] = aScore;
			this._size++;
			return true;
		}
	}

	public Student elementAt(int aPosition) {
		return this._elements[aPosition];
	}

	public void sortStudentsByScore() {
		int size = this._size;
		if (size >= 2) {
			int minLoc = 0;
			for (int i = 1; i < size; i++) {
				if (this._elements[i].score() < this._elements[minLoc].score())
					minLoc = i;
			}
			swap(minLoc, size - 1);
			quickSortRecursively(0, size - 2);
		}

	}

	public int numberOfStudentsAboveAverage() {
		float average = averageScore();
		float score;
		int numberOfStudentsAboveAverage = 0;

		for (int i = 0; i < this._size; i++) {
			score = this._elements[i].score();
			if (score >= average)
				numberOfStudentsAboveAverage++;
		}
		return numberOfStudentsAboveAverage;

	}

	public float averageScore() {
		float sumOfScores = (float) sumOfScoresRecursively(0, this._size - 1);
		float average = sumOfScores / this._size;
		return average;
	}

	public GradeCounter countGrades() {
		char currentGrade;
		GradeCounter gradeCounter = new GradeCounter();
		for (int i = 0; i < this._size; i++) {
			currentGrade = this.scoreToGraer(this._elements[i].score());
			gradeCounter.count(currentGrade);
		}
		return gradeCounter;
	}

	private void quickSortRecursively(int left, int right) {
		int mid;
		if (left < right) {
			mid = this.partition(left, right);
			this.quickSortRecursively(left, mid - 1);
			this.quickSortRecursively(mid + 1, right);
		}

	}

	private void swap(int positionA, int positionB) {
		Student temp = this._elements[positionA];
		this._elements[positionA] = this._elements[positionB];
		this._elements[positionB] = temp;

	}

	private int partition(int left, int right) {
		int pivot = left;
		int pivotScore = this._elements[pivot].score();
		right++;
		do {
			do {
				left++;
			} while (this._elements[left].score() > pivotScore);
			do {
				right--;
			} while (this._elements[right].score() < pivotScore);
			if (left < right)
				this.swap(left, right);
		} while (left < right);
		this.swap(pivot, right);
		return right;
	}

	private float sumOfScoresRecursively(int left, int right) {
		if (left > right) {
			return 0;

		} else {
			return (this._elements[left].score() + this.sumOfScoresRecursively(
					left + 1, right));
		}
	}

	private int maxScoreRecursively(int left, int right) {
		int leftMax;
		int rightMax;

		if (left == right)
			return this._elements[left].score();
		else {
			int mid = (left + right) / 2;
			leftMax = this.maxScoreRecursively(left, mid);
			rightMax = this.maxScoreRecursively(mid + 1, right);
			if (leftMax >= rightMax)
				return leftMax;
			else
				return rightMax;
		}
	}

	private int minScoreRecursively(int left, int right) {
		if (left == right)
			return this._elements[left].score();
		else {
			int leftMin=this._elements[left].score();
			int nextMin=this.minScoreRecursively(left+1, right);
			if(leftMin<=nextMin)
				return leftMin;
			else
				return nextMin;

		}
	}

	private char scoreToGraer(int aScore) {
		if (aScore >= 90)
			return 'A';
		else if (aScore >= 80)
			return 'B';
		else if (aScore >= 70)
			return 'C';
		else if (aScore >= 60)
			return 'D';
		else
			return 'F';
	}

	public int minScore() {
		return this.minScoreRecursively(0, this._size - 1);
	}

	public int maxScore() {
		return this.maxScoreRecursively(0, this._size - 1);
	}
}
