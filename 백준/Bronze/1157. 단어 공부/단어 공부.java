import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int[] alphabet = new int[26]; // 영어 알파벳의 수는 26개이다.

		for (int i = 0; i < str.length(); i++) {
			if (65 <= str.charAt(i) && str.charAt(i) <= 90) {
				alphabet[str.charAt(i) - 65]++;
			} else {
				alphabet[str.charAt(i) - 97]++;
			}
		}

		int count = 0;
		char ch = ' ';
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > count) {
				count = alphabet[i];
				ch = (char) (i + 65);
			} else if (alphabet[i] == count) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}

}
