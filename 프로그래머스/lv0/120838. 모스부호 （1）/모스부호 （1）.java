class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] morse = { 
            ".-:a","-...:b","-.-.:c","-..:d",".:e","..-.:f",
            "--.:g","....:h","..:i",".---:j","-.-:k",".-..:l",
            "--:m","-.:n","---:o",".--.:p","--.-:q",".-.:r",
            "...:s","-:t","..-:u","...-:v",".--:w","-..-:x",
            "-.--:y","--..:z"
        };
        
        for(String s : letter.split(" ")){
            for(String m : morse){
                if(s.equals(m.split(":")[0]))
                    answer += m.split(":")[1];
            }
        }
        
        return answer;
    }
}