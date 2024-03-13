import java.util.*;

public class Main {
    private static ArrayList<Integer>[] adj; // 그래프의 인접 리스트
    private static boolean[] visited; // 방문한 노드를 체크할 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 정점의 개수
        int M = sc.nextInt(); // 간선의 개수
        int V = sc.nextInt(); // 시작 정점 번호

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        
        // 각 정점의 인접리스트를 오름차순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();

        visited = new boolean[N+1];
        bfs(V);
        System.out.println();
        
        sc.close();
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int u : adj[v]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int w : adj[u]) {
                if (!visited[w]) {
                    visited[w] = true;
                    q.offer(w);
                }
            }
        }
    }
}
