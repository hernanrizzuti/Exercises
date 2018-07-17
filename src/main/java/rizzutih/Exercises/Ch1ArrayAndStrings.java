package rizzutih.Exercises;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by h.rizzuti on 22/06/2018.
 */
public class Ch1ArrayAndStrings {


    private String charInsert(final String str,
                              final char c,
                              final int i) {

        final String begin = str.substring(0, i);
        final String end = str.substring(i);
        return begin + c + end;

    }


    public boolean isUnique(final String text) {
        char prev;
        char curr;
        for (int i = 0; i < text.length(); i++) {
            prev = text.charAt(i);
            for (int j = i + 1; j < text.length(); j++) {
                curr = text.charAt(j);
                if (prev == curr) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUniqueChar(final String str) {

        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public String sort(final String string) {
        char[] char_set = string.toCharArray();
        Arrays.sort(char_set);

        return new String(char_set);
    }

    public boolean permutation(final String compare,
                               final String compareTo) {
        if (compare.length() != compareTo.length()) {
            return false;
        }
        return sort(compare).equals(sort(compareTo));

    }

    public char[] urlify(char[] chars, int trueLength) {

        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        char[] newChars = new char[trueLength + spaceCount * 2];

        int index = 0;
        for (int i = 0; index < newChars.length; i++) { //Mr Tom atoes -> Mr%20Tom%20atoes

            if (chars[i] == ' ' && spaceCount > 0) {
                newChars[index] = '%';
                newChars[index + 1] = '2';
                newChars[index + 2] = '0';
                spaceCount--;
                index = index + 3;

            } else {
                newChars[index] = chars[i];
                index++;
            }
        }
        return newChars;
    }

    public boolean isPalindrome(final String word,
                                final String palindrome){

        final StringBuffer str = new StringBuffer(palindrome);
        str.reverse();

        /*final char[] chars = palindrome.toCharArray();
        final StringBuffer str = new StringBuffer();

        final int charsLength = palindrome.length()-1;

        for(int i=charsLength; i >= 0; i--){
            str.append(chars[i]);
        }*/

        if(str.toString().equals(word)){
            return true;
        }

        return false;
    }

    public Set<String> permutation(final String text){

        final Set<String> perm = new HashSet<>();

        if(text == null){
            return null;
        } else if (text.length() == 0) {
            perm.add("");

            return perm;
        }

        final char initChar = text.charAt(0);

        final String rem = text.substring(1);

        final Set<String> words = permutation(rem);

        for (String str : words){
            for(int i = 0; i <=str.length(); i++){
                perm.add(charInsert(str, initChar, i));
            }
        }

        return perm;
    }

    /*
    Palindrome Permutation: Given a string, write a function to check if it's a permutation of palindrome.
    A palindrome is a word or phrase that is the same for and backward. A permutation is a rearrangement of letters.
    The palindrome does not need to be limited to just dictionary words.
    */



    /*
    * OneAway: There are three types of edits that can be performed on string: insert a character,
    * remove a character or replace a character. given two string, write a function to check if they are one edit
    * (or zero edits) away
    * pale, ple -> true
    * pales, pale -> true
    * pale, bale -> true
    * pale, bake -> false
    */

    public boolean isOneAway(final String word,
                             final String wordToCompare) {

        final int wordSize = word.length();
        final int wordToCompareSize = wordToCompare.length();
        int total = wordSize - wordToCompareSize;
        BigDecimal bigDecimalTotal = BigDecimal.valueOf(total);
        total = bigDecimalTotal.signum() == -1 ? bigDecimalTotal.multiply(BigDecimal.valueOf(-1)).intValue() : total;

        char[] words = word.toCharArray();
        char[] wordsToCompare = wordToCompare.toCharArray();

        final int longest, shortest;

        int result = BigDecimal.valueOf(wordSize).compareTo(BigDecimal.valueOf(wordToCompareSize));

        if(result == 1){
            longest = wordSize;
            shortest = wordToCompareSize;
        } else if (result == -1){
            longest = wordToCompareSize;
            shortest = wordSize;
        } else {
            longest = wordSize; //either of the size is the same, therefore first the one was picked.
            shortest = wordSize;
        }

        boolean[] flags = new boolean[longest];

        int index = 0;

        for(int i = index; i < longest; i++){
            if(result != 0 && index == shortest){
                while( total !=0){
                    flags[i] = false;
                    total--;
                }
                break;
            }

            if(words[i] == wordsToCompare[index]) {
                flags[i] = true;
                index++;
            } else {
                if(total == 0) {
                    index++;
                } else {
                    continue;
                }
            }
        }

        int countFalse = 0;

        for(boolean flag : flags){
            if(!flag){
                countFalse++;
            }
        }

        return countFalse == 1 ? true : false;
    }

    /*
    *
    * String Compression: Implement a method to perform basic string compression using the counts of repeated
    * characters. For example, the string aabcccccaa would become a2b1c5a3. If the compressed string would not become
    * smaller that the original then your method should return the original string. You can assume the string has only
    * uppercase or lowercase letters (a-z)
     */

    public String stringCompression(String letters) {
        final Map<Character, Integer> letterCounterMap = new HashMap<>();

        for(char letter :letters.toCharArray()){
            if (letterCounterMap.get(letter) == null) {
                letterCounterMap.put(letter, 1);
            } else {
                letterCounterMap.put(letter, letterCounterMap.get(letter) + 1);
            }
        }
        final StringBuilder compressedLetters = new StringBuilder();

        letterCounterMap.entrySet().forEach(entry -> {
            compressedLetters.append(entry.getKey());
            compressedLetters.append(entry.getValue());
        });

        final String compressed = compressedLetters.toString();

        return  (compressed.length() == letters.length()) ? letters : compressed;
    }


}
