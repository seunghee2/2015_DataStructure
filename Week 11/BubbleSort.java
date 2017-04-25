public class BubbleSort {
	public BubbleSort() {

	}

	public void sort(int[] data, int dataSize) {
		for (int i = 1; i < dataSize; i++)
			for (int j = 0; j < i; j++)
				if (data[j] > data[j + 1]) {
					int temp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = temp;
				}

	}

}

