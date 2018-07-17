package rizzutih;

import org.junit.Before;
import org.junit.Test;
import rizzutih.Exercises.Sieve;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by h.rizzuti on 10/07/2018.
 */

public class SieveTest {

    private Sieve sieve;
    @Before
    public void setUp() throws Exception {
        sieve = new Sieve();

    }

    @Test
    public void testCreateListAddsTo100When100IspassedIn() {
        assertNotNull(sieve.createList(100));
        assertEquals(new Integer(100), sieve.createList(100).get(98));
        assertEquals(new Integer(2), sieve.createList(100).get(0));
    }

    @Test
    public void testFindPrimeFindsPrimeNumbersAndAddThemToANewList() {
        assertEquals(30,sieve.findPrime().size());
    }

}
