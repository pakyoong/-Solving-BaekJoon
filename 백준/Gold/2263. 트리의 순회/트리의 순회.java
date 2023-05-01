import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] inOrder, postOrder, inOrderIndex; // 인오더, 포스트오더 및 인오더 인덱스를 저장할 배열 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 정점의 개수 n 입력 받음

        inOrder = new int[n];
        postOrder = new int[n];
        inOrderIndex = new int[n + 1];

        // 인오더 입력 및 인덱스 정보 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inOrderIndex[inOrder[i]] = i; // 해당 값의 인오더 인덱스 정보 저장
        }

        // 포스트오더 입력
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        // 프리오더를 계산하고 출력하는 함수 호출
        solve(0, n - 1, 0, n - 1);
    }

    // 프리오더를 계산하고 출력하는 함수
    public static void solve(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) { // 종료 조건
            return;
        }

        int root = postOrder[postOrderEnd]; // 포스트오더의 마지막 요소는 항상 루트이다
        System.out.print(root + " "); // 루트를 출력
        int rootIndex = inOrderIndex[root]; // 루트의 인오더 인덱스를 찾음

        int leftSize = rootIndex - inOrderStart; // 왼쪽 서브트리의 크기 계산

        // 왼쪽 서브트리에 대해 재귀 호출
        solve(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + leftSize - 1);
        // 오른쪽 서브트리에 대해 재귀 호출
        solve(rootIndex + 1, inOrderEnd, postOrderStart + leftSize, postOrderEnd - 1);
    }
}
