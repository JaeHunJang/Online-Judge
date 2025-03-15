import java.util.*;
class Solution
{
    char[] str;
    public int solution(String s)
    {
        int answer = 0;
        if (s.length() <= 1) return s.length();
        
        str = s.toCharArray();
        
        for (int i = 0; i < str.length; ++i) {
            answer = Math.max(answer, getPalLen(i, i));
            answer = Math.max(answer, getPalLen(i, i+1));
        }

        return answer;
    }
    
    int getPalLen(int left, int right) {
        while (left >= 0 && right < str.length && str[left] == str[right]) {
            --left;
            ++right;
        }
        
        return right - left - 1;
    }
}