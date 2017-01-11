package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeList {

	public List<Integer> mergeList(List<Integer> l1, List<Integer> l2) {
	
		List<Integer> mergeList = new ArrayList<Integer>();
		int i =0,j=0;
		while(i<l1.size() && j<l2.size()) {
			if(l1.get(i) < l2.get(j)) {
				mergeList.add(l1.get(i));
				i++;
			} if(l1.get(i) == l2.get(j)) {
					mergeList.add(l1.get(i));
					i++;
					j++;
					
			} else {
				mergeList.add(l2.get(j));
				j++;
			}
		}
		for(;i<l1.size();i++) {
			mergeList.add(l1.get(i));
		}
		for(;j<l2.size();j++) {
			mergeList.add(l2.get(j));
		}
		return mergeList;
	}
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
		List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(2,4,6,8));
		MergeList merge = new MergeList();
		List<Integer> mergeList = merge.mergeList(l1, l2);
		for(Integer value:mergeList) {
			System.out.println(value);
		}
	}
	
}
