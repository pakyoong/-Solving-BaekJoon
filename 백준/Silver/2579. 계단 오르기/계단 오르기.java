import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 수
        int[] steps = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            steps[i] = sc.nextInt();
        }
        
       
        dp[1] = steps[1];
        if (n > 1) {
            dp[2] = steps[1] + steps[2];
        }
        
       
        for (int i = 3; i <= n; i++) {
            
            dp[i] = Math.max(dp[i - 2] + steps[i], dp[i - 3] + steps[i - 1] + steps[i]);
        }
        
        System.out.println(dp[n]);
        sc.close();
    }
}
