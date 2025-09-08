import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] grades = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
    static double[] scores = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double score = 0;
        double cnt = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double a = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            if (grade.equals("P")) continue;
            score += a * find(grade);
            cnt += a;
        }
        System.out.println(score / cnt);
    }

    static double find(String grade) {
        for (int i = 0; i < grades.length; i++) {
            if (grade.equals(grades[i])) {
                return scores[i];
            }
        }

        return 0;
    }
}
