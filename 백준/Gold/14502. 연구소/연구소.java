import java.util.ArrayList;
import java.util.Scanner;

class Position {
    int x, y;
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] lab;
    static ArrayList<Position> viruses = new ArrayList<>();
    static ArrayList<Position> blanks = new ArrayList<>();
    static int maxArea = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        lab = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
                if (lab[i][j] == 2) {
                    viruses.add(new Position(i, j));
                } else if (lab[i][j] == 0) {
                    blanks.add(new Position(i, j));
                }
            }
        }
        
        buildWall(0, 0);
        System.out.println(maxArea);
    }
    
    static void buildWall(int start, int depth) {
        if (depth == 3) {
            maxArea = Math.max(maxArea, simulate());
            return;
        }
        
        for (int i = start; i < blanks.size(); i++) {
            Position pos = blanks.get(i);
            lab[pos.x][pos.y] = 1;
            buildWall(i + 1, depth + 1);
            lab[pos.x][pos.y] = 0;
        }
    }
    
    static int simulate() {
        int[][] tempLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(lab[i], 0, tempLab[i], 0, M);
        }
        
        for (Position virus : viruses) {
            spreadVirus(virus.x, virus.y, tempLab);
        }
        
        return getSafeArea(tempLab);
    }
    
    static void spreadVirus(int x, int y, int[][] tempLab) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (tempLab[nx][ny] == 0) {
                    tempLab[nx][ny] = 2;
                    spreadVirus(nx, ny, tempLab);
                }
            }
        }
    }
    
    static int getSafeArea(int[][] tempLab) {
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempLab[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
