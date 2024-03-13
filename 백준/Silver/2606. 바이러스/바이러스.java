import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adj; 
    private static boolean[] visited;
    private static int infectedCount; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerCount = sc.nextInt(); 
        int connectionCount = sc.nextInt(); 

        adj = new ArrayList[computerCount + 1];
        for (int i = 1; i <= computerCount; i++) {
            adj[i] = new ArrayList<>();
        }

       
        for (int i = 0; i < connectionCount; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        visited = new boolean[computerCount + 1]; 
        infectedCount = 0; 

        dfs(1); 

        System.out.println(infectedCount - 1); 
        sc.close();
    }

    private static void dfs(int v) {
        visited[v] = true; 
        infectedCount++; 
        
        for (int u : adj[v]) { 
            if (!visited[u]) {
                dfs(u); 
            }
        }
    }
}
