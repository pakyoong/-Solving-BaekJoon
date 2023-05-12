import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static final int MOD = 1000003;
    private static int N, S, E;
    private static long T;
    private static long[][] A, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        E = Integer.parseInt(input[2]);
        T = Long.parseLong(input[3]);

        A = new long[5 * N + 1][5 * N + 1];
        ans = new long[5 * N + 1][5 * N + 1];
        for (int i = 1; i <= 5 * N; i++) ans[i][i] = 1;

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) - '0' >= 1) {
                    A[i * 5][(j + 1) * 5 - (s.charAt(j) - '0' - 1)] = 1;
                }
            }
            for (int j = 1; j <= 4; j++) {
                A[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;
            }
        }

        mpow();

        System.out.println(ans[5 * S][5 * E]);
    }

    private static void mpow() {
        while (T > 0) {
            if (T % 2 == 1) {
                ans = multiply(ans, A);
            }
            T /= 2;
            A = multiply(A, A);
        }
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[5 * N + 1][5 * N + 1];
        for (int i = 1; i <= 5 * N; i++) {
            for (int j = 1; j <= 5 * N; j++) {
                for (int k = 1; k <= 5 * N; k++) {
                    res[i][j] += (a[i][k] * b[k][j]);
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
