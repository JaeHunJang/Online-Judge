import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            boolean isRight = true;
            int idx = 0;
            for (char ch : skillTree.toCharArray()) {
                if (skill.contains(ch+"")) {
                    if (ch - skill.charAt(idx) == 0) idx++;
                    else {
                        isRight = false;
                        break;
                    }
                }
            }
            if (isRight) answer++;
        }
        
        return answer;
    }
}