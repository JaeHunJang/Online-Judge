class Solution {
    public int solution(String A, String B) {
//         if(A.equals(B)) return 0;
        
//         int answer = 0;
//         StringBuilder sb = new StringBuilder(A);
        
//         for(int i = 0; i < A.length(); i++){
//             System.out.println(sb.toString());
//             if(B.equals(sb.insert(0, sb.toString().charAt(A.length()-1)).deleteCharAt(sb.length()-1).toString())){
//                 answer = i + 1;
//                 break;
//             } else answer = -1;
//         }
//         return answer;
        
        return (B+B).indexOf(A);
    }
}