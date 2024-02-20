import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int N, result[][], entry[], num, maxScore, base[];
    private static boolean visited[];
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
        N = Integer.parseInt(st.nextToken()); // 이닝
        num = 9; // 야구선수
        maxScore = 0; // 최대 점수
        base = new int[3]; // 1~3루
        
        entry = new int[num]; // 선수 타순 저장
        visited = new boolean[num]; 
        
        result = new int[N][num]; // 이닝별 결과 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                result[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    private static void solve() throws Exception {
        visited[0] = true;
        entry[3] = 0;
        selectEntry(0);
        sb.append(maxScore);
    }
    
    private static void selectEntry(int cnt) {
        if (cnt == num) {
        	simulResult();
            return;
        }
        
        for (int i = 0; i < num; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (cnt == 2) {
            	entry[cnt] = i;
                selectEntry(cnt+2);
            } else {
                entry[cnt] = i;
                selectEntry(cnt+1);
            }
            visited[i] = false;
        }
    }
    
    private static void simulResult() {
        int out = 0; // 이닝별 아웃 카운트
        int score = 0; // 현재 선수 엔트리의 결과 점수
        int battingOrder = 0; // 선수의 타순
        
        for (int i = 0; i < N; i++) { // 이닝의 결과
        	Arrays.fill(base, 0); // 1~3루 주자 없도록 초기화
            for (out = 0; out < 3; ) { // 아웃이 3회가 될때까지 이닝 반복 
                if (result[i][entry[battingOrder]] == 0) out++; // 결과가 아웃이면 아웃 카운트 증가
                else {
                	score += move(result[i][entry[battingOrder]]); // 결과가 안타 이상이면 출루해서 홈까지 들어온 선수 반환
                }
                battingOrder = (battingOrder + 1) % num; // 선수의 타순 초기화
            }
        }
        maxScore = Math.max(score, maxScore); // 최대 점수 갱신
    }
    
    private static int move(int cnt) {
        int count = 0; // 홈으로 돌아온 사람 카운트
        for (int i = 0; i < cnt; i++) { // 1루씩 이동
            if (base[2] == 1) count++; // 3루에 주자가 있으면 카운팅
            base[2] = base[1]; // 2루 주자 > 3루로 이동
            base[1] = base[0]; // 1루 주자 > 2루로 이동
            base[0] = 0; // 1루는 주자 이동해서 없음
        }
        if (cnt < 4) // 다 밀어냈으면 출루시키기
        	base[cnt-1] = 1; // 
        if (cnt == 4) // 홈런이면 카운트 증가
        	count++;
        
        return count;
    }
}