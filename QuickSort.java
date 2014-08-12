import a2.A2Item;
import java.util.List;
import java.util.ArrayList;


public class QuickSort {

	private List<A2Item> items;
	private int listElem;

	public QuickSort(List<A2Item> items) {

		if (items == null || items.size() == 0){
			return;
		}
		this.items = items;
		listElem = items.size();
		sort(0, listElem-1);
	}

	private void sort(int low, int high) {
		int i = low;
		int j = high;
		// split into two lists
		double pivot = this.items.get(low + (high-low) / 2).getTransactionValue();

		while (i <= j) {

			// if value from first list is smaller than pivot, get next element in list.
			while (this.items.get(i).getTransactionValue() < pivot) {
				i++;
			}

			// if value from second list is bigger than pivot, get next elem in list.
			while (this.items.get(j).getTransactionValue() > pivot) {
				j--;
			}

			// swap values if first list's value is bigger than pivot, 
			// and if value in second list is smaller than pivot.
			if (i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}

		// recursion 
		if (low < j) {
			sort(low, j);
		}

		if (i < high) {
			sort(i, high);
		}
	}

	// change place of the element
	private void swap(int i, int j) {
		A2Item temp = this.items.get(i);
		this.items.set(i, this.items.get(j));
		this.items.set(j, temp);
	}
}
