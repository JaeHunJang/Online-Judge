class Solution {
    public String solution(String my_string) {
        String[] temp = {"a", "e", "i", "o", "u"};
        
        for(String s : temp)
            my_string = my_string.replaceAll(s, "");
        
        return my_string;
    }
}