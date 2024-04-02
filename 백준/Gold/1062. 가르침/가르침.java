import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, maxRead = 0;
    static String[] words;
    static boolean[] learned = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) { 
            System.out.println(N);
            return;
        }

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", ""); 
        }

        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        teach(0, 0);
        System.out.println(maxRead);
    }
    
    static void teach(int index, int count) {
        if (count == K - 5) {
            maxRead = Math.max(maxRead, countRead());
            return;
        }

        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                teach(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }

    
    static int countRead() {
        int count = 0;
        for (String word : words) {
            boolean canRead = true;
            for (int j = 0; j < word.length(); j++) {
                if (!learned[word.charAt(j) - 'a']) {
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        return count;
    }
}
