import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectedComponents {
	private Map<Integer,Integer> visited = new HashMap<>(); 
	private Map<Integer, Integer> connectedComp = new HashMap<>();
    private  int numberOfComponents(ArrayList<Integer>[] adj) {
         //write your code here
        int componentNo = 0;
        for(int vertex=0; vertex <adj.length;vertex++) {
        	if (! visited.containsKey(vertex)) {
        		explorer(vertex, adj, componentNo);
        	}
        	componentNo++;
        }
        
        return connectedComp.size();
    }
    private void explorer(int n, ArrayList<Integer>[] adj, int componentNo) {
    	connectedComp.put(componentNo, componentNo);
    	visited.put(n, componentNo);
		for(int edge: adj[n]) {
			if( ! visited.containsKey(edge)) {
				explorer(edge,adj, componentNo);			
			}
		}
    }

    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
        
        Scanner scanner =  null;
      try {
			scanner = new Scanner(new File("c://inputFile.Connected.txt"));
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
            adj[y - 1].add(x - 1);
        }
        System.out.println((new ConnectedComponents()).numberOfComponents(adj));
    }
}

