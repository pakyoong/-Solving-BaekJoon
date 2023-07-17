import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int MAX = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수빈이의 위치
        int K = sc.nextInt(); // 동생의 위치

        int[] check = new int[MAX]; // 각 위치에 도달하기까지 걸린 시간을 저장하는 배열
        Arrays.fill(check, -1); // 초기에는 모든 위치를 도달하지 않은 상태(-1)로 세팅

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(check[current]);
                break;
            }

            int[] nextStates = {current - 1, current + 1, 2 * current}; // 이동 가능한 상태들

            for (int nextState : nextStates) {
                // 다음 상태가 범위 내에 있고 아직 방문하지 않은 상태라면
                if (nextState >= 0 && nextState < MAX && check[nextState] == -1) {
                    queue.add(nextState);
                    check[nextState] = check[current] + 1; // 현재까지의 시간에 1초 추가
                }
            }
        }
    }
}
