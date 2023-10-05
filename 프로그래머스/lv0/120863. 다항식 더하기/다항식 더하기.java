class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x = 0;
        int n = 0;
        for(String s : polynomial.split(" ")){
            if(s.contains("x")){
                if(s.length() > 1)
                    x += Integer.parseInt(s.split("x")[0]);
                else x++;
            } 
            else if(Character.isDigit(s.charAt(s.length()-1))) n += Integer.parseInt(s);
        }
        return (x > 0 ? (x > 1 ? x : "") + "x" : "") + (x > 0 && n > 0 ? " + " : "") + (n > 0 ? n + "" : "");
    }
}