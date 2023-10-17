import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // Arrays.fill(answer, -1);
//         LinkedList<Integer> q = new LinkedList();
//         Stack<Integer> stack = new Stack();
        
//         for(int p : prices){
//             q.add(p);
//         }
        
//         for(int i = 0; i < prices.length; i++){
//             // int price = q.pop();
//             while(!stack.isEmpty() && stack.peek() > prices[i]){
//                 System.out.println(prices[i]+"");
//                 answer[i] = stack.size();
//                 stack.pop();
//             }
//             if(answer[i] == -1) answer[i] = stack.size();
            
//             stack.push(prices[i]);
//         }
        
//         int idx = 0;
//         while(!q.isEmpty()){
//             int price = q.pop();
//             for(int i = 0; i < q.size(); i++){
//                 answer[idx] = i+1;

//                 if(price > q.get(i)) { 
//                     // System.out.println(price + "|" + temp[i]);
//                     break;
//                 }
//             }
            
//             // if(q.indexOf(price) > 0) answer[idx] = q.indexOf(price);
//             // if(answer[idx] == -1) answer[idx] = q.size();
//             idx++;
//         }
        
        for(int j = 0; j < prices.length; j++){
            for(int i = j+1; i < prices.length; i++){
                answer[j]++;

                if(prices[j] > prices[i]) { 
                    // System.out.println(price + "|" + temp[i]);
                    break;
                }
            }
        }
        
        
        return answer;
        
//         Stack<Integer> beginIdxs = new Stack<>();
//         int i=0;
//         int[] terms = new int[prices.length];

//         beginIdxs.push(i);
//         for (i=1; i<prices.length; i++) {
//             while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
//                 int beginIdx = beginIdxs.pop();
//                 terms[beginIdx] = i - beginIdx;
//             }
//             beginIdxs.push(i);
//         }
//         while (!beginIdxs.empty()) {
//             int beginIdx = beginIdxs.pop();
//             terms[beginIdx] = i - beginIdx - 1;
//         }

//         return terms;
    }
}