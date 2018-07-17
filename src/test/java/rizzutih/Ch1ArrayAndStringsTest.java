package rizzutih;

import org.junit.Before;
import org.junit.Test;
import rizzutih.Exercises.Ch1ArrayAndStrings;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by h.rizzuti on 22/06/2018.
 */
public class Ch1ArrayAndStringsTest {

    private Ch1ArrayAndStrings ch1ArrayAndStrings;

    @Before
    public void setUp() {
         ch1ArrayAndStrings = new Ch1ArrayAndStrings();
    }

    @Test
    public void testIsUnique() {
        assertEquals(true, ch1ArrayAndStrings.isUnique("herny"));
        assertEquals(false, ch1ArrayAndStrings.isUnique("hernan"));
        assertEquals(false, ch1ArrayAndStrings.isUniqueChar("hernan"));
    }

    @Test
    public void testPermutation() {
        assertTrue(ch1ArrayAndStrings.permutation("herny", "nyhre"));
        assertFalse(ch1ArrayAndStrings.permutation("herny", "nyrqe"));
    }

    @Test
    public void testURLify() {
        char[] chars = "Mr Tom atoes   ".toCharArray();
        char[] expectedChars = "Mr%20Tom%20atoes".toCharArray();
        assertArrayEquals(expectedChars, ch1ArrayAndStrings.urlify(chars, 12));


        char[] chars2 = "Dr Sean M Murphy   ".toCharArray();
        char[] expectedChars2 = "Dr%20Sean%20M%20Murphy".toCharArray();
        assertArrayEquals(expectedChars2, ch1ArrayAndStrings.urlify(chars2, 16));
    }

    @Test
    public void testPermutationReturnList() {

        //When
        Set<String> permutation = ch1ArrayAndStrings.permutation("car");

        assertTrue(permutation.size()==6);
        permutation.remove("car") ;
        permutation.remove("arc") ;
        permutation.remove("acr") ;
        permutation.remove("cra") ;
        permutation.remove("rac") ;
        permutation.remove("rca") ;

        //Then
        assertTrue(permutation.size()==0);
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(ch1ArrayAndStrings.isPalindrome("casa", "asac"));
    }

    @Test
    public void shouldReturnFalse() {
        assertFalse(ch1ArrayAndStrings.isPalindrome("casa", "acac"));
    }

    @Test
    public void shouldReturnTrueWhenPaleAndPleArePassedIn() {
        assertTrue(ch1ArrayAndStrings.isOneAway("pale", "ple"));
    }

    @Test
    public void shouldReturnTrueWhenPaleAndBaleArePassedIn() {
        assertTrue(ch1ArrayAndStrings.isOneAway("pale", "bale"));
    }

    @Test
    public void shouldReturnTrueWhenPalesAndPaleArePassedIn() {
        assertTrue(ch1ArrayAndStrings.isOneAway("pales", "pale"));
    }

    @Test
    public void shouldReturnTrueWhenPaleWith6SAndPaleArePassedIn() {
        assertFalse(ch1ArrayAndStrings.isOneAway("palessssss", "pale"));
    }

    @Test
    public void shouldReturnTrueWhenPaleAndPaleWith6SArePassedIn() {
        assertFalse(ch1ArrayAndStrings.isOneAway("pale","palessssss"));
    }

    @Test
    public void shouldReturnA2B4C1WhenAabbbbcIsPassedIn() {
        assertEquals("a2b4c1", ch1ArrayAndStrings.stringCompression("aabbbbc"));
    }

    @Test
    public void shouldReturnAabbbcWhenAabbbcIsPassedIn() {
        assertEquals("aabbbc", ch1ArrayAndStrings.stringCompression("aabbbc"));
    }
}