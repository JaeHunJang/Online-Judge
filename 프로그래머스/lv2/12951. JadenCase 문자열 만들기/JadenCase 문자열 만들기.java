class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        String[] temp = s.split("");
        boolean flag = true;
        
        for (int i = 0; i < temp.length; i++){
            if(temp[i].equals(" ")) { flag = true;}
            else if(flag) {
                flag = false;
                temp[i] = temp[i].toUpperCase(); 
            }
            
            answer += temp[i];
        }
        
        return answer;
    }
}