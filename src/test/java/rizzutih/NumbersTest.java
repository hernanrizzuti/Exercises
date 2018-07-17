package rizzutih;

import org.junit.Before;
import org.junit.Test;
import rizzutih.Exercises.Numbers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class NumbersTest {

	@Before
	public void setUp(){
	}

	@Test
	public void testCreateArrayReturnsAListWith99numbersWhen100spassedIn() {
		Numbers numbers = new Numbers();
		assertEquals(100, numbers.createArray(100).size());
	}
	
	@Test
	public void testFindMissingNumberReturnsMissingNumber() {
		Numbers numbers = spy(new Numbers());
		when(numbers.randomGen()).thenReturn(5);
		assertEquals(5, numbers.findMissingNumber());
	}
}
