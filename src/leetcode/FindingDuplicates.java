package leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindingDuplicates {

	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		// https://leetcode.com/problems/find-all-duplicates-in-an-array/
		//http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
		List<Integer> integer = new ArrayList<Integer>(Arrays.asList(4,3,2,7,8,2,3,1,100,100));
		List<Integer> repetited = new ArrayList<Integer>();
		int size = integer.size();
		for(int i=0;i<integer.size();i++) {
			int a = Math.abs(integer.get(i).intValue()) % size ;
			int value = integer.get(a);
			if( value < 0) {
				repetited.add(integer.get(i));
				
			} else {
				integer.remove(a);
				integer.add(a, value * -1);
				
			}	
		}
		for(Integer v:repetited) {
			System.out.println(v + " ");
		}
	}
	
	public int[] findDuplicates(int[] input) {
		
		
		
		return input;
		
		
	}

}

