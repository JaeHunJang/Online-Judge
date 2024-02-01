import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	private static StringTokenizer st;
	private static int S;
	private static int P;
	private static int count;
	private static char[] dnaString;
	private static char[] dnaCharactor = {'A', 'C', 'G', 'T'};
	private static int[] useCounts;
	private static int[] counts;
	public static void main(String[] args) throws Exception {
		init();
		solve();
		print();
	}
	private static void print() {
		System.out.println(sb.toString());
	}
	
	private static void init() throws Exception { 
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken()); // 문자열 길이
		P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
		count = 0; // 비밀번호 개수
		dnaString = br.readLine().toCharArray(); // 입력받은 DNA 문자열
		useCounts = new int[dnaCharactor.length]; // DNA문자 사용 횟수
		counts = new int[dnaCharactor.length]; // 부분문자열의 DNA문자 사용 횟수
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < useCounts.length; i++) { // DNA문자 사용 횟수 입력
			useCounts[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void solve() {
		slidingWindow();
	}
	
	private static void slidingWindow() {
		for (int i = 0; i < P; i++) { // 초기값 세팅
			countCharacter(dnaString[i], 1);
		}
		if (validPassword()) count++; // 초기값 검증
		
		for (int i = 1; i < S-P+1; i++) { // i = 1, 다음값부터 시작
			countCharacter(dnaString[i-1], -1); // 앞문자 count 감소
			countCharacter(dnaString[P+i-1], 1); // 뒷문자 count 증가
			if (validPassword()) count++;
		}
		
		sb.append(count);
	}
	
	/**
	 * DNA 문자 사용 횟수가 조건에 맞는지 검사하는 함수
	 * @return
	 */
	private static boolean validPassword() { 
		for (int i = 0; i < useCounts.length; i++) {
			if (useCounts[i] > counts[i]) return false; // 사용횟수가 최소보다 작은지 확인
		}
		return true;
	}
	
	/**
	 * DNA 문자를 검사하여 일치하는 문자에 대한 count 증감 함수
	 * @param ch : 검사할 DNA 문자
	 * @param sign : 증감 부호
	 */
	private static void countCharacter(char ch, int sign) {
		for (int j = 0; j < dnaCharactor.length; j++) {
			if (dnaCharactor[j] == ch)
				counts[j] += sign * 1; 
		}
	}
}