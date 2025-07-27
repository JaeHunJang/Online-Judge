import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < L; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int n = Integer.parseInt(br.readLine());

        if (set.contains(n)) {
            System.out.println(0);
            return;
        }

        Integer lower = set.lower(n);
        Integer upper = set.higher(n);

        int left = (lower == null) ? 1 : lower + 1;
        int right = (upper == null) ? n : upper - 1;

        int cnt = 0;
        for (int a = left; a <= n; a++) {
            for (int b = n; b <= right; b++) {
                if (a != b) cnt++;
            }
        }


        System.out.println(cnt);
    }
}
