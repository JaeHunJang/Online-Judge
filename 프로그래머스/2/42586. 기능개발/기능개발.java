import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> releases = new LinkedList();
        
        Queue<int[]> progressQueue = new LinkedList<>();

        for(int i = 0; i < speeds.length; i++){
            progressQueue.add(new int[]{progresses[i], speeds[i]});
        }
//         for(int i = 0;!progressQueue.isEmpty(); i++){
//                 int[] temp = progressQueue.poll();
            
//             System.out.println(temp[0]+"|" +temp[1]);

//         }
        
        while(!progressQueue.isEmpty()){
            int cnt = 0;
            // for(int i = 0;!progressQueue.isEmpty(); i++){
//                 int[] temp = progressQueue.poll();
            
//             System.out.println(temp[0]+"|" +temp[1]);

//         }
            for(int i = 0; i < progressQueue.size(); i++){
                int[] temp = progressQueue.poll();
                temp[0] += temp[1];
                progressQueue.add(temp);
                
            }
            
//             for(int i = 0;!progressQueue.isEmpty(); i++){
//                 int[] temp = progressQueue.poll();
            
//             System.out.println(temp[0]+"|" +temp[1]);

//         }
            while(!progressQueue.isEmpty() && progressQueue.peek()[0] >= 100) {
                progressQueue.poll();
                cnt++;
                
            }
            if(cnt > 0) releases.add(cnt);
        }
        
        int[] answer = new int[releases.size()];
        for(int i = 0; i < releases.size(); i++){
            answer[i] = releases.get(i);
        }
        // System.out.println(sb.toString());
        
        return answer;
    }
}