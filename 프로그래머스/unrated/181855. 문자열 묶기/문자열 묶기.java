class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] temp = new int[strArr.length];
        
        for(String s : strArr)
            temp[s.length()]++;
        
        for(int i = 0; i < temp.length; i++){
            answer = Math.max(temp[i], answer);
        }
        
        return answer;
    }
}