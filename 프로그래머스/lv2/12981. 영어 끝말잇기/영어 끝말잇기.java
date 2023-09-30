import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 1; //사람과 단어순서 확인용
        boolean flag = true; //단어 배열의 순회 여부
        
        int[] using = new int[words.length]; //단어 중복 사용여부
        using[0]++; //첫 단어는 넘김
        
        for(int i = 1; i < words.length; i++ ) {
            answer[0] = cnt % n+1; //사람
            answer[1] = (cnt+n) / n; //순서
            cnt++;
            using[i]++;
            
            if(words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) { //끝말잇기 규칙 검사
                flag = false;
                break;
            }
            else {
                for(int j = 0; j < i; j++){ //단어 중복사용 검사
                    if(words[i].equals(words[j])) using[i]++;
                }
                if (using[i] > 1) {
                    flag = false;
                    break;
                }
            }
        }
        if (cnt == words.length && flag) return new int[]{0, 0};

        return answer;
    }
}