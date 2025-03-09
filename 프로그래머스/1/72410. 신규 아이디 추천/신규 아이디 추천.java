class Solution {
    public String solution(String new_id) {
        
        return step7(step6(step5(step34(step2(step1(new_id))))));
    }
    
    String step1(String id) {
        return id.toLowerCase();
    }
    
    String step2(String id) {
        StringBuilder sb = new StringBuilder();
        for (char ch : id.toCharArray()) {
            if (ch == '-' || ch == '_' || ch == '.' 
                || (ch >= 'a' && ch <= 'z') 
                || (ch >= '0' && ch <= '9')
               ) sb.append(ch);
        }
        return sb.toString();
    }
    
    String step34(String id) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (i < id.length() && id.charAt(i) == '.') {
            while(++i < id.length() && id.charAt(i) == '.');
        }
        for (; i < id.length(); ++i) {
            if (id.charAt(i) == '.') {
                sb.append(".");
                while(i < id.length() && id.charAt(i) == '.') ++i;
                --i;
            } else {
                sb.append(id.charAt(i));
            }
        }
        
        i = sb.length()-1;
        while (i >= 0 && sb.charAt(i) == '.') {
            --i;
        }
        if (i != sb.length()-1) {
            sb.setLength(i+1);            
        }
        
        return sb.toString();
    }
    
    String step5(String id) {
        return id.length() == 0 ? "a" : id;
    }
    
    String step6(String id) {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        if (id.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(14) == '.') {
                sb.setLength(14);
            }
        }
        
        return sb.toString();
    }
    
    String step7(String id) {
        if (id.length() <= 2) {
            char ch = id.charAt(id.length()-1);
            while(id.length() < 3) {
                id += ch;
            }
        }
        
        return id;
    }
}