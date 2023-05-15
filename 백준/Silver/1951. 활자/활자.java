import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long answer = 0;

        while(n > 9) {
            long len = Long.toString(n).length();
            answer += (n - Math.pow(10, len - 1) + 1) * len;
            n = (long) Math.pow(10, len - 1) - 1;
        }

        answer += n;
        System.out.println(answer % 1234567);
    }
}
