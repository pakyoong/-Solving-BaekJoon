import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 시험 본 과목의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 세준이의 현재 성적을 담을 배열 생성
        int[] scores = new int[N];

        // 세준이의 현재 성적 입력받아 배열에 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 최대값 구하기
        int max = 0;
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        // 모든 점수를 점수/M*100으로 고쳐서 새로운 평균 구하기
        double sum = 0;
        for (int score : scores) {
            sum += (double) score / max * 100;
        }
        double avg = sum / N;

        // 결과 출력
        System.out.println(avg);
	    }
}