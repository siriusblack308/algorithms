import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StronglyConntectedComponents {
	
	
	public List<Integer> transposeGraph(List<Integer>[] adj) {
		List<Integer> transpose[] = (ArrayList<Integer>[])new ArrayList[adj.length];
		for(int i =0;i<adj.length;i++) {
		 
		}
		
	}
	
	
	
	
	 public static void main(String[] args) {
	       Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int m = scanner.nextInt();
	        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
	        for (int i = 0; i < n; i++) {
	            adj[i] = new ArrayList<Integer>();
	        }
	        for (int i = 0; i < m; i++) {
	            int x, y;
	            x = scanner.nextInt();
	            y = scanner.nextInt();
	            adj[x - 1].add(y - 1);
	            adj[y - 1].add(x - 1);
	        }
	        int x = scanner.nextInt() - 1;
	        int y = scanner.nextInt() - 1;
	        System.out.println();
	    }
	}
}
