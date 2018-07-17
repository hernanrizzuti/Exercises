package rizzutih;

import org.junit.Before;
import org.junit.Test;
import rizzutih.Exercises.BubbleSort;

import static org.junit.Assert.assertEquals;

public class BubbleSortTest {

	@Before
	public void setUp() {
	}

	@Test
	public void testSortListReturnsAnOrderedListOfTwoElements() {
		BubbleSort bubbleSort = new BubbleSort();
		assertEquals(new Integer(0), bubbleSort.sortList(bubbleSort.randomNumList(10)).get(0));
	}
	
	@Test
	public void testSortListReturnsAnOrderedList() {
		BubbleSort bubbleSort = new BubbleSort();
//		assertEquals(new Integer(1), bubbleSort.sortList(4).get(1));
		System.out.println(bubbleSort.sortList(bubbleSort.randomNumList(100)));
	}
}
