import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxDistance = 0;

    public static void dfs(int x, int y, int count) {
        maxDistance = Math.max(maxDistance, count);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[board[nx][ny] - 'A']) {
                    visited[board[nx][ny] - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    visited[board[nx][ny] - 'A'] = false; 
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        R = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        board = new char[R][C];
        
        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true; 
        dfs(0, 0, 1);
        System.out.println(maxDistance);
    }
}
