// CMSC 350 Data Structures and Analysis
// Week 1 Examples
// Dr. Duane J. Jarc
// March 1, 2020

// This class illustrates the use of one feature of Java generics--unbounded
// wildcards. The method display displays a list of elements of an
// arbitrary type.
package Generics;

import java.util.*;

public class UnboundedWildcard
{
	public static void main(String[] args)
	{
		Integer[] integerArray = {1, 2, 3, 4, 5};
		List<Integer> integerList = new ArrayList();
		integerList.addAll(Arrays.asList(integerArray));
		display(integerList);
		
		String[] stringArray = {"a", "ab", "abb"};
		List<String> stringList = new ArrayList();
		stringList.addAll(Arrays.asList(stringArray));
		display(stringList);
	}
		
	private static void display(List<?> list)
	{
		for (Object element: list)
			System.out.println(element);
	 }
}