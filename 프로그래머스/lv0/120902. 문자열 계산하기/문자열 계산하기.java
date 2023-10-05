class Solution {
    public int solution(String my_string) {
        int answer = Integer.parseInt(my_string.split(" ")[0]);
        
        String calc = "";
        
        for(String s : my_string.split(" ")){
            if("+".equals(s) || "-".equals(s)) calc = s;
            else {
                switch(calc){
                    case "+": answer += Integer.parseInt(s); break;
                    case "-": answer -= Integer.parseInt(s); break;
                }
                calc = "";
            }
        }
        
        
        
        
        return answer;
    }
}