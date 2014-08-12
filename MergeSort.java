import a2.A2Item;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

// Studied online samples code and implemented my own class to fit ArrayList and Item class objects 
// to sort by transaction value.
// Impelmented Comparator and then I override the compare method to compare Item class transactionValue.

public class MergeSort implements Comparator<A2Item> {

	public MergeSort() {
		// ...
	}

	public MergeSort(List<A2Item> items) {
		this.sort(items);
	}

	public List<A2Item> sort(List<A2Item> items) {
		if (items.size() <= 1) {  // when list is 1, it's sorted - return it.
			return items;
		}
		// create two list for splitting arraylist.
		List<A2Item> a = new ArrayList<A2Item>();
		List<A2Item> b = new ArrayList<A2Item>();

		// find center of list to split list in two halves
		int center = items.size() / 2;

		// add first half to new list a.
		for (int i=0; i<center; i++) {
			a.add(items.get(i));
		}

		// add second half to new list b.
		for (int i=items.size()-1; i>=center; i--) {
			b.add(items.get(i));
		}

		// recursion on lists
		a = sort(a);
		b = sort(b);

		// when sorted and returned, merge the lists.
		return merge(a, b);
	}

	// merge list a and b into list c.
	public List<A2Item> merge(List<A2Item> a, List<A2Item> b) {
		List<A2Item> c = new ArrayList<A2Item>();

		while (a.size() > 0 || b.size() > 0) {
			if (a.size() > 0 && b.size() > 0) {
				if (this.compare(a.get(0), b.get(0)) <= 0) {  // call compare on list a and b
					c.add(a.remove(0));
				}
				else {
					c.add(b.remove(0));
				}
			}
			else if (a.size() > 0) {
				c.add(a.remove(0));
			}
			else if (b.size() > 0) {
				c.add(b.remove(0));
			}
		}
		return c;
	}

	@Override
	public int compare(A2Item i1, A2Item i2) {
		double v1 = i1.getTransactionValue();
		double v2 = i2.getTransactionValue();

		if (v1 > v2) {
			return 1;
		}
		if (v1 == v2) {
			return 0;
		}
		return -1;
	}
}
