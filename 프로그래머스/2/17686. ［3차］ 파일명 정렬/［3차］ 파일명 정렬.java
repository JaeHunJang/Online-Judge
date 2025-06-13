import java.util.*;

class Solution {
    class File {
        String origin, head, number, tail;
        int num, idx;
        File (String origin, String head, String number, int idx) {
            this.origin = origin;
            this.head = head;
            this.num = Integer.parseInt(number);
            this.idx = idx;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        File[] convFiles = new File[files.length];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String originFile : files) {
            String f = originFile.toLowerCase();
            int idx = 0;
            sb.setLength(0);
            for (char ch : f.toCharArray()) {
                if (!Character.isDigit(ch)) {
                    sb.append(ch);
                    idx++;
                } else {
                    break;
                }
            }
            String head = sb.toString();
            f = f.substring(idx);
            sb.setLength(0);
            idx = 0;
            
            for (char ch : f.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                    idx++;
                } else {
                    break;
                }
            }
            String num = sb.toString();
            convFiles[i] = new File(originFile, head, num, i++);
        }
        Arrays.sort(convFiles, (o1, o2) -> {
            if (o1.head.compareTo(o2.head) == 0) {
                if (Integer.compare(o1.num, o2.num) == 0) {
                    return Integer.compare(o1.idx, o2.idx);
                }
                return Integer.compare(o1.num, o2.num);
            }
            return o1.head.compareTo(o2.head);
        });
        
        i = 0;
        for (File f : convFiles) {
            answer[i] = convFiles[i].origin;
            i++;
        }
        return answer;
    }
}