package a2;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface A2Main {
	public List<A2Item> readCSVFile(String filename);

	/** Sort array by transaction value with bubble sort algorithm */
	public long bubbleSortByTransactionValue(List<A2Item> array);

	/** Sort array by transaction value with quick sort algorithm */
	public long quickSortByTransactionValue(List<A2Item> array);

	/** Sort array by transaction value with merging sort algorithm, using priority queue and comparator */
	public long mergeSortByTransactionValue(List<A2Item> array);

	public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<A2Item> array);

	public void printResults(TreeSet<Map.Entry<String, Long>> results);



	public void doCompareAlgorithms(List<A2Item> items);
	public void createHashMap(List<A2Item> items);
}
