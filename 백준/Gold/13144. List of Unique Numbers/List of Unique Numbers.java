import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        int left = 0;
        
        for (int right = 0; right < N; right++) {
           if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]) + 1);
            }
            
            map.put(arr[right], right);
            
            count += right - left + 1;
        }
        
        System.out.println(count);
    }
}
