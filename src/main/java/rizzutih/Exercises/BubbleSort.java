package rizzutih.Exercises;

import java.util.Collections;
import java.util.List;

public class BubbleSort {

	public List<Integer> sortList(List<Integer> list) {
		int listLength = list.size();
		int left = 0;
		int right = 1;
		int furthestRight = listLength -1;
		while(!(furthestRight==0)){
			if(list.get(left) > list.get(right)){
				int newRight = list.remove(left);
				list.add(right, newRight);
			}
			left++;
			right++;
			if(listLength == right){
				left = 0;
				right = 1;
			}
			if(furthestRight == list.get(furthestRight)){
				furthestRight--;
			}
		}
		return list;
	}

	public List<Integer> randomNumList(int listLength) {
		Numbers num = new Numbers();
		List<Integer> list = num.createArray(listLength);
		Collections.shuffle(list);
		return list;
	}
}