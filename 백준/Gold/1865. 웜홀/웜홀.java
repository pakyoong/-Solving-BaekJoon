import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 500 * 10_000;

    static class Edge {
        int start, end, time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine()); 

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 
            int W = Integer.parseInt(st.nextToken()); 

            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T)); 
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edges.add(new Edge(S, E, -T)); 
            }

            sb.append(bellmanFord(N, edges) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb.toString());
    }

    static boolean bellmanFord(int N, ArrayList<Edge> edges) {
        int[] time = new int[N + 1];
        Arrays.fill(time, INF);
        time[1] = 0;

        boolean updated = false;
        for (int i = 0; i < N; i++) {
            updated = false;
            for (Edge e : edges) {
                if (time[e.end] > time[e.start] + e.time) {
                    time[e.end] = time[e.start] + e.time;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        return updated; 
    }
}
