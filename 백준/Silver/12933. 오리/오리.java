import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 오리 / 60분
public class Main {
    static String input;
    static final String sound = "quack";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        int[] soundCounts = new int[5];
        HashMap<Character, Integer> soundIndex = new HashMap<>();

        for (int i = 0; i < sound.length(); i++) {
            soundIndex.put(sound.charAt(i), i);
        }

        int maxDucks = 0;
        int activeDucks = 0;

        for (char ch : input.toCharArray()) {
            int index = soundIndex.getOrDefault(ch, -1);
            if (index == -1) {
                System.out.println(-1);
                return;
            }
            soundCounts[index]++;
            if (ch == 'q') { 
                activeDucks++;
                maxDucks = Math.max(maxDucks, activeDucks);
            }
            if (index > 0 && soundCounts[index] > soundCounts[index - 1]) {
                System.out.println(-1);
                return;
            }
            if (ch == 'k') {
                activeDucks--;
            }
        }

        for (int i = 1; i < 5; i++) {
            if (soundCounts[i] != soundCounts[0]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(maxDucks);

    }
}