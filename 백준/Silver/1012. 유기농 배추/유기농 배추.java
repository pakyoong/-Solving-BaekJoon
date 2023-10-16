import java.io.*;
import java.util.*;

public class Main {

    static int[][] field; // 배추밭을 표현할 2차원 배열
    static boolean[][] visited; // 해당 위치를 방문했는지 표시할 2차원 배열
    static int M, N; // 배추밭의 가로길이 M과 세로길이 N
    static int[] dx = {-1, 1, 0, 0}; // x 좌표의 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1}; // y 좌표의 상하좌우 이동을 위한 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 T

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); // 배추의 위치의 개수 K

            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추의 위치를 입력 받아 field 배열에 표시
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            int count = 0; // 연결된 배추 그룹의 수를 저장할 변수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 배추가 있고, 아직 방문하지 않은 위치라면 DFS 시작
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++; // DFS가 끝나면 연결된 그룹을 하나 찾은 것이므로 count 증가
                    }
                }
            }
            System.out.println(count); // 연결된 배추 그룹의 수 출력
        }
    }

    // 깊이 우선 탐색(DFS) 함수
    static void dfs(int x, int y) {
        visited[x][y] = true; // 현재 위치를 방문했음을 표시

        // 상하좌우 방향으로의 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // nx와 ny가 배추밭의 범위 내에 있고
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                // 해당 위치에 배추가 있으며 아직 방문하지 않았다면 DFS 재귀 호출
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
