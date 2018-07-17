package rizzutih;

import org.junit.Before;
import org.junit.Test;
import rizzutih.Exercises.PrimeSieve;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeSieveTest {
	
	private PrimeSieve ps;
	List<Integer> list, prime;
	Integer total;
	@Before
	public void setup(){
		list = new ArrayList<Integer>();
		prime = new ArrayList<Integer>();
		ps = new PrimeSieve(list);
		
	}
	
	@Test
	public void testGenerateNumbersReturnsArrayOfIntsFrom2To100() {
		total = 100;
		assertEquals(total, ps.generatenumbers().get(list.size()-1));
	}
	
	@Test
	public void moveHeadToPrimeResultSet(){
		assertEquals(new Integer(2),ps.generatePrimeList(ps.generatenumbers(),prime).get(0));
	}
	
	@Test
	public void testGeneratePrimeListReturnsAllDivisibleNumbersByTwoWhenTwoIsTheHeadOfArray(){
		assertEquals(new Integer(2), ps.generatePrimeList(ps.generatenumbers(),prime).get(0));
	}
	
	@Test
	public void testGeneratePrimeListReturnsAllPrimeNumbers(){
		List<Integer> primes = ps.generatePrimeList(ps.generatenumbers(),prime);
		assertEquals(new Integer(2),primes.get(0));
		assertEquals(new Integer(3),primes.get(1));
		assertEquals(new Integer(5),primes.get(2));
	}
}
