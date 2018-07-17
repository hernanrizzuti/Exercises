package rizzutih.Exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sieve {

	public List<Integer> createList(int number) {
		List<Integer> list = new ArrayList<>();
		for(int i= 2; i <= number; i++){
			list.add(i);
		}
		return list;
	}

	public List<Integer> findPrime() {
		List<Integer> primeList = new ArrayList<>();
		List<Integer> numberlist = createList(121);
		int number;
		Iterator<Integer> itr = numberlist.iterator();
		while(itr.hasNext()) {
			int prime = numberlist.remove(0);
			primeList.add(prime);
			for(int i = 1;i < numberlist.size();i++){
				number = numberlist.get(i);
				if(number % prime == 0){
					numberlist.remove(numberlist.indexOf(number));	
				}
			}
		}
		return primeList;
	}
}