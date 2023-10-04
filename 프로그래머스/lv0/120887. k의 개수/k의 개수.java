class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(; i <= j; i++){
            for(String s : (i+"").split("")){
                if((k+"").equals(s)) answer++;
            }
        }
        
        // for (int num = i; num <= j; num++){
        //     int tmp = num;
        //     while (tmp != 0){
        //         if (tmp % 10 == k)
        //             answer++;
        //         tmp /= 10;
        //     }
        // }
        
        return answer;
        
//         String str = "";
//         for(int a = i; a <= j; a++) {
//             str += a+"";
//         }
        
//         return str.length() - str.replace(k+"", "").length();
        
        
    }
}