import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] convTerms = new int[26];
        for (int i = 0; i < terms.length; i++) {
            convTerms[terms[i].charAt(0) - 'A'] = Integer.parseInt(terms[i].split(" ")[1]);
        }
        
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            int nowTerm = privacies[i].charAt(privacies[i].length()-1) - 'A';
            st = new StringTokenizer(privacies[i].split(" ")[0], ".");
            int year2 = Integer.parseInt(st.nextToken());
            int month2 = Integer.parseInt(st.nextToken());
            int day2 = Integer.parseInt(st.nextToken());
            int date = (year - year2) * 12 * 28 + (month - month2) * 28 +  (day - day2);
            if ((date / 28) >= convTerms[nowTerm]) {
                answer.add(i+1);
            }
            
        }
        
        int[] arr = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }
}