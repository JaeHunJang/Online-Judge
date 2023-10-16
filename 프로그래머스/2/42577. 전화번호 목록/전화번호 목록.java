import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap();
        
        Arrays.sort(phone_book);
        // System.out.println(Arrays.toString(phone_book));
        
//         int idx = 0;
//         for(String p : phone_book){
//             System.out.println(p + "|" + map.size() + map.containsKey(p));
            
//             if(map.size() == 0) map.put(p, idx++);
//             else if(map.containsKey(p)) {
//                 for(String k : map.keySet()){
//                     System.out.println(p + "|" + k);
                    
//                     if(k.startsWith(p)) return false;
//                 }
//             } else map.put(p, idx++);
//         }
        
        
        
        
        for(int i = 1; i < phone_book.length; i++){
            if( phone_book[i].startsWith(phone_book[i-1])) return false;
            
            // for(int j = 0; j < phone_book.length; j++)
            // if(map.containsKey(phone_book[i])) return false;
        }
        
        return true;
    }
}