import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] fenceStr = br.readLine().split(" ");
        int[] fences = new int[N];

        for (int i = 0; i < N; i++) {
            fences[i] = Integer.parseInt(fenceStr[i]);
        }

        Arrays.sort(fences);

        double[][] dp = new double[N][1 << N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.printf("%.10f\n", solve(0, 0, fences, dp));
    }

    private static double solve(int idx, int bitmask, int[] fences, double[][] dp) {
        if (idx == fences.length) {
            return 0;
        }

        if (dp[idx][bitmask] != -1) {
            return dp[idx][bitmask];
        }

        double maxArea = solve(idx + 1, bitmask, fences, dp);

        for (int i = 0; i < fences.length; i++) {
            for (int j = i + 1; j < fences.length; j++) {
                for (int k = j + 1; k < fences.length; k++) {
                    if ((bitmask & (1 << i)) == 0 && (bitmask & (1 << j)) == 0 && (bitmask & (1 << k)) == 0) {
                        if (fences[i] + fences[j] > fences[k]) {
                            double area = getTriangleArea(fences[i], fences[j], fences[k]);
                            int newBitmask = bitmask | (1 << i) | (1 << j) | (1 << k);
                            maxArea = Math.max(maxArea, area + solve(idx + 1, newBitmask, fences, dp));
                        }
                    }
                }
            }
        }

        return dp[idx][bitmask] = maxArea;
    }

    private static double getTriangleArea(int a, int b, int c) {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
