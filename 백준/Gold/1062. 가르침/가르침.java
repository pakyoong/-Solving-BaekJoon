import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // N : 단어의 개수
    // K : 배울 수 있는 글자의 수
    // maxRead : 읽을 수 있는 최대 단어 수
    static int N, K, maxRead = 0;
    // words : 주어진 남극어 단어 저장하는 배열
    static String[] words;
    // learned : 배웠는지 여부 확인 배열
    static boolean[] learned = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // "anta"로 시작되고, "tica"로 끝난다. 'a, n, t, i, c' 5개
        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) { 
            System.out.println(N);
            return;
        }

        // 이때, 모든 단어는 anta로 시작하고 tica로 끝나므로, 이 부분을 제외한 나머지 글자들만을 고려합니다.
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", ""); 
        }

        // 기본 글자들(a, n, t, i, c)은 이미 배웠다고 표시
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        // 모든 글자 조합을 시도
        teach(0, 0);
        // 최대 읽을 수 있는 단어 수 출력
        System.out.println(maxRead);
    }
    
    // 모든 글자 조합 시도
    static void teach(int index, int count) {
        // 현재까지 선택한 글자의 수가 K-5와 같다면, 읽을 수 있는 단어 수를 계산
        if (count == K - 5) {
            maxRead = Math.max(maxRead, countRead());
            return;
        }

        // 가능한 모든 글자에 대해 배웠는지 여부를 반복하여 확인하고, 배우지 않은 글자를 선택합니다.
        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                teach(i + 1, count + 1);
                learned[i] = false; // 백트래킹을 위해 다시 배우지 않은 상태로 되돌립니다.
            }
        }
    }

    // 선택한 글자로 읽을 수 있는 단어의 수 계산
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