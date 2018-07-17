package rizzutih.Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Numbers {

	public int findMissingNumber() {
		List<Integer> orderedList = createArray(100);
		for(int number : removeAndShuffledList()){
			orderedList.remove(orderedList.indexOf(number));
		}
		return orderedList.get(0);
	}
	
	public List<Integer> createArray(int number) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<number; i++){
			list.add(i);
		}
		return list;
	}

	public List<Integer> removeAndShuffledList() {
		List<Integer> unOrderedList = createArray(100);
		unOrderedList.remove(randomGen());
		Collections.shuffle(unOrderedList);
		return unOrderedList;
	}

	public int randomGen() {
		Random rn = new Random();
		return rn.nextInt(99 - 0 + 1) + 0;
	}
}