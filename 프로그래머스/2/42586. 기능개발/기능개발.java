import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> releases = new LinkedList();
        Queue<int[]> progressQueue = new LinkedList<>();

        //Queue 초기값 
        for(int i = 0; i < speeds.length; i++){
            progressQueue.add(new int[]{progresses[i], speeds[i]});
        }
        
        while(!progressQueue.isEmpty()){
            int cnt = 0;
            for(int i = 0; i < progressQueue.size(); i++){
                int[] temp = progressQueue.poll();
                temp[0] += temp[1];
                progressQueue.add(temp);
            }
            
            while(!progressQueue.isEmpty() && progressQueue.peek()[0] >= 100) {
                progressQueue.poll();
                cnt++;
            }
            if(cnt > 0) releases.add(cnt);
        }
        
        //정답배열 만들기
        int[] answer = new int[releases.size()];
        for(int i = 0; i < releases.size(); i++){
            answer[i] = releases.get(i);
        }
        
        return answer;
    }
}