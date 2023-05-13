import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];
        List<Integer> L = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int idx = 0, dptmp = 0;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            num[i] = a;
            if (L.isEmpty()) {
                L.add(num[i]);
                dp[i] = 1;
            } else {
                if (L.get(L.size() - 1) < num[i]) {
                    L.add(num[i]);
                    dp[i] = L.size();
                } else {
                    int pos = Collections.binarySearch(L, num[i]);
                    if (pos < 0) pos = -(pos + 1);
                    L.set(pos, num[i]);
                    dp[i] = pos + 1;
                }
            }
            if (dp[i] > dptmp) {
                idx = i;
                dptmp = dp[i];
            }
        }
        System.out.println(L.size());
        s.push(num[idx]);
        for (int i = idx - 1; i >= 0; i--) {
            if (num[i] < num[idx] && dp[i] + 1 == dp[idx]) {
                idx = i;
                s.push(num[i]);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
