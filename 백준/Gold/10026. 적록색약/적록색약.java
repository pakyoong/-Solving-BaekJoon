import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int n;
    static char[][] photo;
    static boolean[][] isVisited;

    // 이동할 4가지 방향을 정의 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    // 깊이 우선 탐색 (DFS)을 수행하는 함수
    public static void dfs(int x, int y, char color) {
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (!isVisited[nx][ny] && photo[nx][ny] == color) {
                dfs(nx, ny, color);
            }
        }
    }

    // 구역의 수를 세는 함수
    public static int countRegions() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j, photo[i][j]);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 방문 여부 배열을 초기화하는 함수
    public static void resetVisited() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], false);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        photo = new char[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            photo[i] = scanner.next().toCharArray();
        }

        // 적록색약이 아닌 사람이 보는 경우의 구역 수를 계산하고 출력
        System.out.print(countRegions() + " ");

        // 적록색약인 사람이 보는 경우를 위해 'G'를 'R'로 변경
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (photo[i][j] == 'G') photo[i][j] = 'R';
            }
        }
        // 방문 여부 배열을 초기화하고, 적록색약인 사람이 보는 경우의 구역 수를 계산하여 출력
        resetVisited();
        System.out.println(countRegions());
    }
}
