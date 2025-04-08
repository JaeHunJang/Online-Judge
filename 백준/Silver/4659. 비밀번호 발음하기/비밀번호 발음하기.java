import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String word = br.readLine();
            if ("end".equals(word)) break;

            boolean hasVowel = false;
            boolean noThreeSameType = true;
            boolean noDoubleExceptEO = true;

            int vowelStreak = 0, consonantStreak = 0;
            char prev = 0;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                boolean isVowel = "aeiou".indexOf(c) >= 0;

                if (isVowel) {
                    hasVowel = true;
                    vowelStreak++;
                    consonantStreak = 0;
                } else {
                    consonantStreak++;
                    vowelStreak = 0;
                }

                if (vowelStreak >= 3 || consonantStreak >= 3) {
                    noThreeSameType = false;
                    break;
                }

                if (i > 0) {
                    if (c == prev && c != 'e' && c != 'o') {
                        noDoubleExceptEO = false;
                        break;
                    }
                }

                prev = c;
            }

            if (hasVowel && noThreeSameType && noDoubleExceptEO) {
                sb.append("<").append(word).append("> is acceptable.\n");
            } else {
                sb.append("<").append(word).append("> is not acceptable.\n");
            }
        }

        System.out.print(sb);
    }
}
