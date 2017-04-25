public class QuickSort {
	public QuickSort() {

	}

	public void sort(int[] data, int dataSize) {
		if (dataSize > 1) {
			int maxLoc = 0;
			for (int i = 1; i < dataSize; i++) {
				if (data[i] > data[maxLoc])
					maxLoc = i;
			}
			swap(data, maxLoc, dataSize - 1);
			quickSortRecursively(data, 0, dataSize - 2);
		}

	}

	private void quickSortRecursively(int[] data, int left, int right) {
		int pivot, up, down;
		if (left < right) {
			pivot = left;
			up = left;
			down = right + 1;
			do {
				do {
					up++;
				} while (data[pivot] > data[up]);
				do {
					down--;
				} while (data[pivot] < data[down]);
				if (up < down) {
					swap(data, up, down);
				}
			} while (up < down);
			swap(data, pivot, down);
			int mid = down;
			quickSortRecursively(data, left, mid - 1);
			quickSortRecursively(data, mid + 1, right);

		}
	}

	private void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;

	}

}
