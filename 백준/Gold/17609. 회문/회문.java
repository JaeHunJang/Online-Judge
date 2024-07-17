import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// 회문
public class Main {
    static String input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            int left = 0, right = input.length() - 1;
            int answer = 0;
            while (left < right) {
                if (input.charAt(left) != input.charAt(right)) { // 문제가 있을 때
                    if (isPal(left+1, right) || isPal(left, right-1))
                        answer = 1;
                    else answer = 2;
                    break;
                }
                left++;
                right--;
            }

            System.out.println(answer);
        }

    }

    static boolean isPal(int left, int right) {
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}