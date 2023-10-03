class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        String[] temp = my_string.substring(s,e+1).split("");
        
        for(int i = 0; i < temp.length; i++)
            answer += temp[temp.length - 1 -i];

        return my_string.replace(my_string.substring(s,e+1), answer);
    }
}