public class InsertionSort {

	public InsertionSort() {

	}

	public void sort(int[] data, int dataSize) {
		for (int i = 1; i < dataSize; i++) {
			int temp = data[i];
			int j = i - 1;
			while (j >= 0 && data[j] > temp) {
				data[j + 1] = data[j];
				j--;
			}
			data[j + 1] = temp;
		}

	}

}
