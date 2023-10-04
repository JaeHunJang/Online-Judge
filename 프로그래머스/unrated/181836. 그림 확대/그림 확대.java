class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        
        for(int i = 0; i < picture.length; i++){
            String temp = "";
            for(String s : picture[i].split("")){
                temp += s.repeat(k);
            }
            for(int j = i * k; j < k * (i+1); j++)
                answer[j] = temp;
        }
        
        return answer;
    }
}