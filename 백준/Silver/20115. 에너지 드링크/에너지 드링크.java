import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] drinks = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        double maxDrink = 0;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            drinks[i] = Integer.parseInt(st.nextToken());
            if (drinks[i] > maxDrink) {
                idx = i;
                maxDrink = drinks[i];
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == idx) continue;
            maxDrink += drinks[i] / 2d;
        }

        System.out.println(maxDrink);
    }
}