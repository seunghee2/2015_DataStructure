public class SelectionSort {
	public SelectionSort() {

	}

	public void sort(int[] data, int size) {
		int i = 0;
		while (i != size) {
			int min = data[i];
			for (int j = size - 1; j < size; j++)
				if (min > data[j])
					min = data[j];
			sort(data, i);
			i++;
		}
	}

}
