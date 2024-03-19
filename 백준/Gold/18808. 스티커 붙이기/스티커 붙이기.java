import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] notebook;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        notebook = new int[N][M];
        
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];
            
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            
            attachSticker(sticker);
        }
        
        System.out.println(countStickers());
    }
    
    private static boolean tryAttach(int[][] sticker, int startX, int startY) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    if (startX + i >= N || startY + j >= M || notebook[startX + i][startY + j] == 1) {
                        return false;
                    }
                }
            }
        }
        
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    notebook[startX + i][startY + j] = 1;
                }
            }
        }
        
        return true;
    }
    
    private static int[][] rotate(int[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;
        int[][] rotated = new int[C][R];
        
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                rotated[i][R - 1 - j] = sticker[j][i];
            }
        }
        
        return rotated;
    }
    
    private static void attachSticker(int[][] sticker) {
        for (int rotation = 0; rotation < 4; rotation++) {
            boolean attached = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tryAttach(sticker, i, j)) {
                        attached = true;
                        break;
                    }
                }
                if (attached) break;
            }
            if (attached) break;
            sticker = rotate(sticker);
        }
    }
    
    private static int countStickers() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) count++;
            }
        }
        return count;
    }
}
