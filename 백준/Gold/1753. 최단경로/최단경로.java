import java.util.*;

public class Main {

    // 간선을 표현하는 클래스
    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정점 개수와 간선 개수 입력
        int V = scanner.nextInt();
        int E = scanner.nextInt();

        // 시작 정점 입력
        int start = scanner.nextInt();

        // 그래프 초기화 (인접 리스트)
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.get(u).add(new Edge(v, w));
        }

        // 다익스트라 알고리즘 수행
        int[] distances = new int[V + 1];
        Arrays.fill(distances, Integer.MAX_VALUE); // 초기 거리 값을 무한대로 설정
        distances[start] = 0;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll(); // 현재 정점 꺼내기
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (currentWeight > distances[currentVertex]) {
                continue; // 이미 처리된 경우 건너뜀
            }

            for (Edge neighbor : graph.get(currentVertex)) {
                int nextVertex = neighbor.vertex;
                int nextWeight = currentWeight + neighbor.weight;

                if (nextWeight < distances[nextVertex]) {
                    distances[nextVertex] = nextWeight; // 거리 갱신
                    priorityQueue.add(new Edge(nextVertex, nextWeight)); // 다음 정점 추가
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println("INF"); // 경로가 없으면 INF 출력
            } else {
                System.out.println(distances[i]); // 최단 거리 출력
            }
        }

        scanner.close();
    }
}
