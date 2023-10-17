import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        for(int n : scoville){
            heap.add(n);
        }
        
        // while(!heap.isEmpty()){
        while(heap.size() > 1 && heap.peek() < K){
            heap.add(heap.poll() + (heap.poll() * 2));
            
            // if(heap.peek() < K) {
            //     if(heap.size() < 2) return -1;
            // } else break;
            answer++;
        }
        //pqScov.size() > 1 && pqScov.peek() < K
        
        if(heap.size() < 2 && heap.peek() < K) return -1;
        
        return answer;
    }
}