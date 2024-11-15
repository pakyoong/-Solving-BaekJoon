
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

// 3124. 최소 스패닝 트리

public class Solution {
	public static int find(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent, parent[x]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스의 수
		
		// 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램
		// 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
		// 입력으로 주어지는 그래프는 하나의 연결 그래프임이 보장된다.
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// V : 정점의 개수, E : 간선의 개수
			int V = sc.nextInt();
			int E = sc.nextInt();
			// 각 간선에 대한 정보를 나타내는 세 정수 A, B, C
			// A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다.
			int[][] edges = new int[E][3];
			for(int i =0; i< E; i++) {
                edges[i][0] = sc.nextInt()-1;
                edges[i][1] = sc.nextInt()-1;
                edges[i][2] = sc.nextInt();
            }
			System.out.println("#" + test_case + " " + kruskal(V, E, edges));
			
			
			
		}
	}
	
	// Kruskal 알고리즘
	// 1. 모든 간선을 가중치를 기준으로 정렬한다.
	// 2. 가중치가 작은 간선부터 차례대로 선택하면서 트리를 증가시킨다.
	// 3. 사이클이 생기면 해당 간선을 선택하지 않는다.
	// 4. 모든 정점이 연결될 때까지 2~3을 반복한다.
	public static long kruskal(int V, int E, int[][] edges) {
		// 간선을 가중치를 기준으로 정렬
		Arrays.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));

		// 각 정점이 포함된 그래프가 어디인지 저장
		int[] parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		long result = 0;
		long cnt = 0;
		for (int i = 0; i < E; i++) {
			int a = find(parent, edges[i][0]);
			int b = find(parent, edges[i][1]);

			if (a == b)
				continue;

			union(parent, a, b);
			result += edges[i][2];
			cnt++;

			if (cnt == V - 1)
				break;
		}

		return result;
	}
	private static void union(int[] parent, int a, int b) {
		int rootA = find(parent, a);
		int rootB = find(parent, b);

		if (rootA != rootB) {
			parent[rootA] = b;
		}
		
	}
	
	
}
