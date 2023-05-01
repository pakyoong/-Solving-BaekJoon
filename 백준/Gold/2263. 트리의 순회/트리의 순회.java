import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrder, postOrder, inOrderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIndex = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndex[inOrder[i]] = i;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, n - 1, 0, n - 1);
    }

    public static void solve(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            return;
        }

        int root = postOrder[postOrderEnd];
        System.out.print(root + " ");
        int rootIndex = inOrderIndex[root];

        int leftSize = rootIndex - inOrderStart;
        solve(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + leftSize - 1);
        solve(rootIndex + 1, inOrderEnd, postOrderStart + leftSize, postOrderEnd - 1);
    }
}