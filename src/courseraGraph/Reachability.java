import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reachability {
	private Map<Integer,Integer> visited = new HashMap<>(); 
    private int reach(ArrayList<Integer>[] adj, int x, int y) {
    	explorer(x, adj);
		//write your code here
		if(visited.containsKey(x) && visited.containsKey(y)) {
			return 1;
		}
		return 0;
    }

    private void explorer(int n, ArrayList<Integer>[] adj) {

		visited.put(n, n);
		for(int edge: adj[n]) {
			if( ! visited.containsKey(edge)) {
				explorer(edge,adj);			
			}
		}

	}

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
//    	Scanner scanner =  null;
//        try {
//			scanner = new Scanner(new File("c://inputFile.txt"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
        System.out.println((new Reachability()).reach(adj, x, y));
    }
}

