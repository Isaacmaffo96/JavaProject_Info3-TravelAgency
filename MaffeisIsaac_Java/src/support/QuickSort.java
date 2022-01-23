package support;

import java.util.ArrayList;

//Implementazione dell'algoritmo di ordinamento quick sort utilizzando i generici
//come pivot viene scelto l'ultimo elemento
//low: indice iniziale
//high: indice finale

public abstract class QuickSort<T extends Comparable<T>> {

	public static <T extends Comparable<T>> void quicksort(ArrayList<T> arr) {
		quicksort_w(arr, 0, arr.size() - 1);
	}

	private static <T extends Comparable<T>> void quicksort_w(ArrayList<T> arr, int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high); // indice di partizione
			quicksort_w(arr, low, p - 1);
			quicksort_w(arr, p + 1, high);
		}
	}

	private static <T extends Comparable<T>> void swap(ArrayList<T> arr, int i, int j) {
		T temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

//Questa funzione prende l'ultimo elemento come pivot e lo mette nella sua posizione corretta,
//posiziona tutti gli elementi più piccoli del pivot a sinistra e tutti gli elementi più grandi a destra.
	private static <T extends Comparable<T>> int partition(ArrayList<T> arr, int low, int high) {
		T p = arr.get(high); // pivot
		int i = (low - 1); // indice dell'elemento più piccolo
		for (int j = low; j <= high - 1; j++)
			if (arr.get(j).compareTo(p) < 0)
				swap(arr, ++i, j);
		swap(arr, i + 1, high);
		return i + 1;
	}

}
