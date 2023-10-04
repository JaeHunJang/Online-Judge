class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
//         String temp1 = "";
//         String temp2 = "";
        
//         int i = 0;
//         for(int j : num_list){
//             if(i++ < n) temp1 += j;
//             else temp2 += j;
//         }
        
//         i = 0;
//         temp1 = temp2 + temp1;
//         for(String s : temp1.split("")){
//             answer[i++] = Integer.parseInt(s);
//         }
        
        for(int i = 0; i < answer.length; i++){
            answer[(i + (answer.length - n)) % answer.length] = num_list[i];
        }
        
        return answer;
    }
}