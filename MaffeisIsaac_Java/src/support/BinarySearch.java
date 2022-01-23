package support;
//Implementazione ricorsiva dell'algoritmo di ricerca "Binary search"

import java.util.ArrayList;

public abstract class BinarySearch<T extends Comparable<T>> {
	// return l'indice di x se è presente nell'aeey, altrimenti -1
	
	public static <T extends Comparable<T>> int binarySearch(ArrayList<T> arr, T x) {
		return binarySearch_w(arr, 0, arr.size(), x);
	}
	
	private static <T extends Comparable<T>> int binarySearch_w(ArrayList<T> arr, int l, int r, T x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;
			if (arr.get(mid).equals(x))
				return mid;
			if (arr.get(mid).compareTo(x) > 0)
				return binarySearch_w(arr, l, mid - 1, x);
			return binarySearch_w(arr, mid + 1, r, x);
		}
		return -1;
	}
}