class Solution {
    public int solution(String my_string, String is_suffix) {

        // for(int i = 0; i < my_string.length(); i++){
        //     if(my_string.substring(i).equals(is_suffix)) return 1;
        // }
        
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }
}