// CMSC 350 Data Structures and Analysis
// Week 1 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class illustrates the use of one feature of Java generics--lower 
// bound wildcards. The method copyList copies a list of elements of an
// arbitrary type to a list of elements of any super type of that type.
package Generics;

import java.util.*;

public class LowerBoundWildcard 
{
	public static void main(String[] args)
	{
		List<Number> numberList = new LinkedList();

		Integer[] integerArray = {1, 2, 3, 4, 5};
		List<Integer> integerList = new ArrayList();
		integerList.addAll(Arrays.asList(integerArray));
		copyList(integerList, numberList);

		Double[] doubleArray = {6., 7., 8., 9., 10.};
		List<Double> doubleList = new ArrayList();
		doubleList.addAll(Arrays.asList(doubleArray));
		copyList(doubleList, numberList);
		
		display(numberList);
	}
		
	private static <T> void copyList(List<T> from, List<? super T> to)
	{
		for (T element: from)
			to.add(element);
	}
	private static void display(List<?> list)
	{
		for (Object element: list)
			System.out.println(element);
	}
}