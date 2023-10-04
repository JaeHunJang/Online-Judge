class Solution {
    public int[] solution(int[] num_list, int n) {
        String temp1 = "";
        String temp2 = "";
        
        int i = 0;
        for(int j : num_list){
            if(i++ < n) temp1 += j;
            else temp2 += j;
        }
        
        i = 0;
        temp1 = temp2 + temp1;
        int[] answer = new int[temp1.length()];
        for(String s : temp1.split("")){
            answer[i++] = Integer.parseInt(s);
        }
        
        return answer;
    }
}