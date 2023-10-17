import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        for(int n : scoville){
            heap.add(n);
        }
        
        while(!heap.isEmpty()){
            if(heap.peek() < K) {
                if(heap.size() < 2) return -1;
                heap.add(heap.poll() + (heap.poll()*2));
            } else break;
            answer++;
        }
        
        return answer;
    }
}