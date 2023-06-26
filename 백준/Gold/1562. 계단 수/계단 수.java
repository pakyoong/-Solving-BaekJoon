import java.util.Scanner;

public class Main {
    static int mod = 1000000000;
    static int[][][] dp = new int[101][10][1024];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // Initialize for length 1
        for(int i = 1; i <= 9; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = 0; k < 1024; k++){
                    if(j == 0){
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                    } else if(j == 9){
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                    } else {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                    }
                    dp[i][j][k | (1 << j)] %= mod;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i <= 9; i++){
            sum = (sum + dp[n][i][1023]) % mod;
        }
        System.out.println(sum);
    }
}
