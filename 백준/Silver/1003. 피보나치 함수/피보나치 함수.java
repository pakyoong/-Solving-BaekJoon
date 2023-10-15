import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력과 출력을 위한 BufferedReader와 BufferedWriter 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 첫 번째 줄에 있는 테스트 케이스의 수를 읽어옴
        int T = Integer.parseInt(br.readLine());
        
        // dp 배열을 초기화. dp[i][0]은 i를 인수로 하는 피보나치 함수에서 0이 호출되는 횟수, 
        // dp[i][1]은 1이 호출되는 횟수를 나타냄
        int[][] dp = new int[41][2];
        
        // 초기값 설정. fibonacci(0)을 호출하면 0이 한 번, 1이 0번 호출됨
        dp[0][0] = 1; 
        dp[0][1] = 0; 
        
        // fibonacci(1)을 호출하면 0이 0번, 1이 한 번 호출됨
        dp[1][0] = 0; 
        dp[1][1] = 1; 

        // 2부터 40까지 각각의 숫자에 대해 0과 1이 몇 번 호출되는지 계산
        for (int i = 2; i <= 40; i++) {
            // fibonacci(i) = fibonacci(i-1) + fibonacci(i-2) 이므로, 
            // fibonacci(i)에서 0이 호출되는 횟수는 
            // fibonacci(i-1)에서 0이 호출되는 횟수와 fibonacci(i-2)에서 0이 호출되는 횟수의 합과 같음
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            
            // 마찬가지로 1이 호출되는 횟수도 같은 원리로 계산
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        // 각 테스트 케이스에 대해 결과 출력
        for (int i = 0; i < T; i++) {
            // 테스트 케이스의 값을 읽어옴
            int N = Integer.parseInt(br.readLine());
            // 결과 출력
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        // 리소스 정리
        br.close();
        bw.flush();
        bw.close();
    }
}