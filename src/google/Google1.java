package google;


//You are given a sorted list of distinct integers from 0 to 99, for instance [0, 1, 2, 
//50, 52, 75]. Your task is to produce a string that describes numbers missing from 
//the list; in this case "3-49,51,53-74,76-99". 
//
//Examples: 
//
//[] “0-99” 
//[0] “1-99” 
//[3, 5] “0-2,4,6-99”
public class Google1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[] array = {1,2,10,11,12,15,90,100};
			int start = array[0];
			for(int i=1;i<array.length;i++) {
				if(array[i] == start +1) {
					start = array[i];
				} else {
					System.out.println("[" + (start + 1 )+ " -" + (array[i] -1) + "]");
					start = array[i];
				}
			}
	}

}
