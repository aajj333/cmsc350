// CMSC 350 Data Structures and Analysis
// Week 1 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class illustrates the use of one feature of Java generics--bounded 
// types. The method isSorted accepts an array of any type that implements
// the Comparable interface and determines whether it is in sorted order.
package Generics;

public class BoundedType
{
	public static void main(String[] args)
	{
		Integer[] sorted1 = {1, 2, 3, 4, 5}, unsorted1 = {3, 4, 1, 6, 5};
		System.out.println("Sorted = " + isSorted(sorted1));
		System.out.println("Unsorted = " + isSorted(unsorted1));
		
		String[] sorted2 = {"a", "ab", "abb"}, unsorted2 = {"a", "z", "b"}; 
		System.out.println("Sorted = " + isSorted(sorted2));
		System.out.println("Unsorted = " + isSorted(unsorted2));
	}

	public static <T extends Comparable> boolean isSorted(T[] array)
	{
		for (int i = 1; i < array.length; i++)
			if (array[i-1].compareTo(array[i]) > 0)
				return false;
		return true;
	}
}