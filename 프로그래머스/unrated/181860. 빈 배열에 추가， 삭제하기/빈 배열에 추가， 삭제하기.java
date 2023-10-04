class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        
        String temp = "";
        
        for(int i = 0; i < arr.length; i++){
            temp = flag[i] ? temp + (arr[i] + "").repeat(arr[i] * 2) : temp.substring(0, temp.length()-arr[i]);
        }
        
        int[] answer = new int[temp.length()];
        int i = 0;
        for(String s : temp.split(""))
            answer[i++] = Integer.parseInt(s);
        
        return answer;
    }
}