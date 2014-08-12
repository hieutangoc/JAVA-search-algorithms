import a2.A2Main;
import a2.A2Item;

import java.io.Console;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.AbstractMap;
import java.util.Comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Main implements A2Main {

	public static void main(String[] args) {
		A2Main main = new Main();
		List<A2Item> items = new ArrayList<A2Item>();
		items = main.readCSVFile("input.txt");

		// compare algorithms
		main.doCompareAlgorithms(items);

		// create HashMap
		main.createHashMap(items);
	}

	public void doCompareAlgorithms(List<A2Item> items) {
		// TreeSet compare algorithms
		TreeSet<Map.Entry<String, Long>> treeSet = this.compareAlgorithms(items);
		this.printResults(treeSet);

	}

	public void createHashMap(List<A2Item> items) {
		// create HashMap with all items. no duplicates allowed.
		HashMap<Integer, A2Item> hashMap = new HashMap<Integer, A2Item>();
		for (Iterator<A2Item> iter = items.iterator(); iter.hasNext();) {
			A2Item item = iter.next();
			hashMap.put(item.hashCode(), item);
		}

		// print HashMap
		System.out.println("\nPrinting HashMap content of size " + hashMap.size() + ":\n");
		for (Map.Entry<Integer, A2Item> entry : hashMap.entrySet()) {
			Integer key = entry.getKey();
			A2Item value = entry.getValue();
			String performer = value.getPerformer();
			double transactionValue = value.getTransactionValue();
			String date = value.getDate();
			System.out.println("Key: " + key + ", Name: " + performer + 
							   ", Transaction value: " + transactionValue + ", Date: " + date + ".");
		}
		System.out.println();
	}

	public List<A2Item> readCSVFile(String filename) {

		List<A2Item> items = new ArrayList<A2Item>();

		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] arr = line.split(",");
				A2Item item = new Item(arr[0], Double.parseDouble(arr[1]), arr[2]);
				items.add(item);
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return items;
	}

	/** Sort array by transaction value with bubble sort algorithm */
	public long bubbleSortByTransactionValue(List<A2Item> array) {
		// start time measurement
		long startTime = System.nanoTime();

		A2Item temp;
		int size = array.size();
		for (int i=0; i<size; i++) {
			for (int j=i+1; j<size; j++) {
				if (array.get(j).getTransactionValue() < array.get(i).getTransactionValue()) {
					temp = array.get(i);
					array.set(i, array.get(j));
					array.set(j, temp);
				}
			}
		}

		// stop time measurement
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

	/** Sort array by transaction value with quick sort algorithm */
	public long quickSortByTransactionValue(List<A2Item> array) {
		// start time measurement
		long startTime = System.nanoTime();

		// sort
		QuickSort quickSort = new QuickSort(array);

		// stop time measurement
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

	/** Sort array by transaction value with merging sort algorithm, using priority queue and comparator */
	public long mergeSortByTransactionValue(List<A2Item> array) {
		// start time measurement
		long startTime = System.nanoTime();

		// sort
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(array);

		// stop time measurement
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;

		return elapsedTime;
	}

	public TreeSet<Map.Entry<String, Long>> compareAlgorithms(List<A2Item> array) {

		TreeSet<Map.Entry<String, Long>> treeSet = new TreeSet<Map.Entry<String, Long>>();
		treeSet.add(new MyEntry<String, Long>("MergeSort", this.mergeSortByTransactionValue(array)));
		treeSet.add(new MyEntry<String, Long>("QuickSort", this.quickSortByTransactionValue(array)));
		treeSet.add(new MyEntry<String, Long>("BubbleSort", this.bubbleSortByTransactionValue(array)));

		return treeSet;
	}

	public void printResults(TreeSet<Map.Entry<String, Long>> results) {

		System.out.println("\nComparing " + results.size() + " sorting algorithms:\n");
		System.out.println("ALGORITHM NAME\t\tTIME SPENT");

		for (Iterator<Map.Entry<String, Long>> iter = results.iterator(); iter.hasNext();) {
			Map.Entry<String, Long> obj = iter.next();
			System.out.println(obj.getKey() + "\t\t" + obj.getValue() + " ns.");
		}
		System.out.println();
	}
}
