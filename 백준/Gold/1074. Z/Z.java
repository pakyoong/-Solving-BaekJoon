import java.io.*;
import java.util.*;

public class Main {

	static int N, r, c; // N은 2의 N승의 배열 크기, r과 c는 찾고자하는 좌표
	static int count = 0; // (r, c)를 방문할 때까지의 카운트

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값 분리를 위한 StringTokenizer

		N = Integer.parseInt(st.nextToken()); // 배열의 크기 2^N x 2^N
		r = Integer.parseInt(st.nextToken()); // 타겟의 행 좌표
		c = Integer.parseInt(st.nextToken()); // 타겟의 열 좌표

		z((int)Math.pow(2, N), 0, 0); // Z 모양으로 탐색 시작. 시작 크기는 2^N
	}

	public static void z(int size, int x, int y) {
		// 현재 위치 (x, y)가 우리가 찾고자 하는 (r, c)인지 확인
		if (x == r && y == c) {
			System.out.println(count); // 찾았다면 현재까지의 카운트 출력
			return;
		}

		// 현재의 size로 분할된 영역 내에 (r, c)가 존재하는 경우
		if (r < x + size && r >= x && c < y + size && c >= y) {
			int newSize = size / 2; // 현재 크기의 절반으로 축소

			z(newSize, x, y); // 왼쪽 위 영역 탐색
			z(newSize, x, y + newSize); // 오른쪽 위 영역 탐색
			z(newSize, x + newSize, y); // 왼쪽 아래 영역 탐색
			z(newSize, x + newSize, y + newSize); // 오른쪽 아래 영역 탐색
		} else { 
			// (r, c)가 현재 영역에 존재하지 않으면 그 영역은 전부 건너뛰기 때문에
			// 카운트에 현재 영역의 크기만큼 더해줌
			count += size * size;
		}
	}
}
