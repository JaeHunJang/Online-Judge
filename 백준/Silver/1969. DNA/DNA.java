import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 N과 M을 입력 받음
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder word = new StringBuilder();
        int dist = 0;

        for (int i = 0; i < M; i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < N; j++) {
                char ch = arr[j].charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue(); // 빈도 내림차순
                }
                return a.getKey() - b.getKey(); // 알파벳 오름차순
            });

            char mostCommonChar = entryList.get(0).getKey();
            int count = entryList.get(0).getValue();

            word.append(mostCommonChar);
            dist += N - count;
        }

        System.out.println(word.toString());
        System.out.println(dist);
    }
}
