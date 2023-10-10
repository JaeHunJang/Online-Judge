class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pc = 0, yc = 0;
        char[] ss = s.toUpperCase().toCharArray();
        for(int i = 0; i < ss.length; i++){
            if((ss[i] == 'P'))
                pc++;
            else if(ss[i] == 'Y')
                yc++;        
        }
        s = "'p'의 개수 "+pc+"개, 'y'의 개수 "+yc+"개로 "+((answer = (pc == yc)?true:false)?"같으":"다르")+"으므로 "+answer+"를 return 합니다.";
        System.out.println(s);
        return answer;
    }
}