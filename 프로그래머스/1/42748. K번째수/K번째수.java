import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int i = 0;
        for (int[] cmd : commands) {
            int[] tmp = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
            Arrays.sort(tmp);
            answer[i++] = tmp[cmd[2]-1];
        }
        return answer;
    }
}