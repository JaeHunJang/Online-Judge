import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static int N;
	private static int[] primeNum = {2, 3, 5, 7};
	private static List<Integer> list;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		for (int n : list) {
			sb.append(n).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		N = Integer.parseInt(br.readLine()); // 자리수
		
		list = new ArrayList<>(); // 만든 소수를 저장할 list
	}
	
	private static void solve() {
		// 1은 소수가 아니기 때문에 1의 자리수에서 소수인 2, 3, 5, 7로 시작
		for (int i = 0; i < primeNum.length; i++) {
			recursive(1, primeNum[i]);
		}
	}
	
	/**
	 * 자리수만큼 재귀로 숫자를 만들어줌
	 * @param count
	 * @param num
	 */
	private static void recursive(int count, int num) {
		// 자리수마다 만든 숫자가 소수여야 하기 때문에 소수가 아니라면 더이상 진행할 필요 없음.
		if (!isPrime(num)) return; 

		// 자리수 만큼 만든 숫자는 소수로 list에 저장
		if (count == N) {
			list.add(num);
		}
		
		// 1부터 시작 (0 으로 시작시 다음 값은 10만 곱해지는데 이 경우 2로 나눠질 수 있기 때문에 제외)
		for (int i = 1; i <= 9; i++) {
			recursive(count+1, num*10+i);
		}
	}
	
	/**
	 * 소수인지 판별하는 함수
	 * @param num 소수를 판별할 수
	 * @return
	 */
	private static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}