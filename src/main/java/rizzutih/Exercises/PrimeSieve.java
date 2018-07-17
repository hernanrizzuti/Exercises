package rizzutih.Exercises;

import java.util.Iterator;
import java.util.List;

public class PrimeSieve {
	
	private List<Integer> list;

	public PrimeSieve(List<Integer> list) {
		this.list = list;
	}

	public List<Integer> generatenumbers() {
		for(int i = 2; i <= 100; i++){
			list.add(i);
		}
		return list;
	}

	public List<Integer> generatePrimeList(List<Integer> listallNumber, List<Integer> prime) {
		if(listallNumber.isEmpty()){
			return prime;
		}
		int head = listallNumber.remove(0);
		prime.add(head);
		removeDivisible(head);
		generatePrimeList(listallNumber, prime);
		return prime;
	}

	private void removeDivisible(int head) {
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			if(it.next() % head == 0)
				it.remove();
		}
	}
}