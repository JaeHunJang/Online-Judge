import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
// 원본        
//        String[] temp = {"aya", "ye", "woo", "ma"};

//         ArrayList<String> list = new ArrayList();
//         for(String s1 : temp){
//             list.add(s1);
//             for(String s2 : temp){
//                 list.add(s1+s2);
//                 for(String s3 : temp){
//                     list.add(s1+s2+s3);
//                     for(String s4 : temp)
//                         list.add(s1+s2+s3+s4);
//                 }
//             }
//         }
        
//         for(String b : babbling){
//             for(String s : list){
//                 if(b.equals(s)) answer++;
//             }
//         }
        
        // for(int i =0; i < babbling.length; i++) {
        //     babbling[i] = babbling[i].replace("aya", "1");
        //     babbling[i] = babbling[i].replace("woo", "1");
        //     babbling[i] = babbling[i].replace("ye", "1");
        //     babbling[i] = babbling[i].replace("ma", "1");
        //     babbling[i] = babbling[i].replace("1", "");
        //     if(babbling[i].isEmpty()) {
        //         answer = answer + 1;
        //     }
        // }
        
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                answer++;
            }
        }
        
        return answer;
    }
}