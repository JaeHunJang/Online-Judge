import java.util.*;
class Solution {
    int[] scores = new int[8];
    String cmd = "RTCFJMAN";
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 4) {
                scores[cmd.indexOf(survey[i].charAt(1)+"")] += choices[i]-4;
            }
            if (choices[i] < 4) {
                scores[cmd.indexOf(survey[i].charAt(0)+"")] += Math.abs(choices[i]-4);
            }
        }
        // System.out.println(Arrays.toString(scores));
        for (int i = 0; i < scores.length; i+=2) {
            if (scores[i] >= scores[i+1]) {
                answer+= cmd.charAt(i);
            } else {
                answer+= cmd.charAt(i+1);
            }
        }
        
        return answer;
    }
}