// CMSC 350 Data Structures and Analysis
// Week 1 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class illustrates the use of one feature of Java generics--bounded 
// wildcards. The method isSorted accepts a List of elements of any type that 
// implements the Comparable interface and determines whether it is in sorted
// order.
package Generics;

import java.util.*;

public class BoundedWildcard 
{
	public static void main(String[] args)
	{
		Integer[] sortedArray1 = {1, 2, 3, 4, 5}, 
			unsortedArray1 = {3, 4, 1, 6, 5};
		List<Integer> sorted1 = new ArrayList(), unsorted1 = new ArrayList();
		sorted1.addAll(Arrays.asList(sortedArray1));
		unsorted1.addAll(Arrays.asList(unsortedArray1));		
		System.out.println("Sorted = " + isSorted(sorted1));
		System.out.println("Unsorted = " + isSorted(unsorted1));
		
		String[] sortedArray2 = {"a", "ab", "abb"};
		String[] unsortedArray2 = {"a", "z", "b"}; 
		List<String> sorted2 = new ArrayList(), unsorted2 = new ArrayList();
		sorted2.addAll(Arrays.asList(sortedArray2));
		unsorted2.addAll(Arrays.asList(unsortedArray2));		
		System.out.println("Sorted = " + isSorted(sorted2));
		System.out.println("Unsorted = " + isSorted(unsorted2));	 
	}
		
	private static boolean isSorted(List<? extends Comparable> list)
	{
		for (int i = 1; i < list.size(); i++)
			if (list.get(i-1).compareTo(list.get(i)) > 0)
				return false;
		return true;
	}
}