import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static class File {
        String name, extension;
        boolean isExt;

        File (String name, String extension) {
            this.name = name;
            this.extension = extension;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, List<Integer>> map = new HashMap<>();
        File[] files = new File[N];
        for (int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            List<Integer> list = map.getOrDefault(file[1], new ArrayList<>());
            list.add(i);
            map.put(file[1], list);
            files[i] = new File(file[0], file[1]);
        }

        for (int i = 0; i < M; i++) {
            List<Integer> list = map.getOrDefault(br.readLine(), new ArrayList<>());
            for (int idx : list) {
                files[idx].isExt = true;
            }
        }

        Arrays.sort(files, (o1, o2) -> {
            if (o1.name.compareTo(o2.name) == 0) { // 파일명 같을 때
                if (o1.isExt && o2.isExt) { // 둘다 인식하는 확장명
                    return o1.extension.compareTo(o2.extension);
                } else if (o1.isExt) {
                    return -1;
                } else if (o2.isExt) {
                    return 1;
                }
                return o1.extension.compareTo(o2.extension);
            }
            return o1.name.compareTo(o2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(files[i].name).append(".").append(files[i].extension).append("\n");
        } 
        System.out.println(sb);
    }
}