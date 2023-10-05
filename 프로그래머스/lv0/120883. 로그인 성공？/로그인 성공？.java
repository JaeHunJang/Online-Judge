class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for(String[] recode : db){
            if(id_pw[0].equals(recode[0]))
                if(id_pw[1].equals(recode[1])) {
                    return "login";
                } else {
                    return "wrong pw";
                }
        }
        return "fail";
    }
}