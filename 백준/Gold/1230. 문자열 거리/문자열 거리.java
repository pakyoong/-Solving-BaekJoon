import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int INF = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int na = a.length();
        int nb = b.length();

        if (na > nb) {
            System.out.println(-1);
            return;
        }

        int[][][] dp = new int[na + 1][nb + 1][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = INF;

        for (int i = 1; i <= nb; i++) {
            dp[0][i][0] = INF;
            dp[0][i][1] = 1;
        }

        for (int i = 0; i < na; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i + 1][j][0] = dp[i + 1][j][1] = INF;
            }
            for (int j = i; j < nb; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1][0] = Math.min(dp[i][j][0], dp[i][j][1]);
                } else {
                    dp[i + 1][j + 1][0] = INF;
                }
                dp[i + 1][j + 1][1] = Math.min(dp[i + 1][j][0] + 1, dp[i + 1][j][1]);
            }
        }

        int result = Math.min(dp[na][nb][0], dp[na][nb][1]);
        System.out.println((result >= INF) ? -1 : result);
    }
}
