import java.io.*;
import java.util.*;

class Edge {
    int start, end, time;

    Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}

public class Main {
    static int N, M;
    static Edge[] edges;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; 

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, time);
        }

        if (bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static boolean bellmanFord() {
        boolean updated = false;

        for (int i = 1; i <= N; i++) {
            updated = false;

            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                    updated = true;

                    if (i == N) return true;
                }
            }

            if (!updated) break;
        }

        return false;
    }
}