import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
       for(int vertex = 0;vertex<adj.length;vertex++)
       {
    	 dfs(adj,used,order,vertex);  
       }
       Collections.reverse(order);
       return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
    	if (used[s] == 1)
    		return;
    	used[s] = 1;
    	for(int edge:adj[s]) {
    		dfs(adj,used,order, edge);
    	}
    	order.add(s);
      
    }

    public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
        
    	Scanner scanner =  null;
      try {
			scanner = new Scanner(new File("c://inputFile.Topology.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

