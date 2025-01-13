import java.util.*;
class Solution {
    boolean[] bools = new boolean[10];
    
    public String[] solution(String[] expressions) {
        ArrayList<String> result = new ArrayList<>();
        Arrays.fill(bools, true);

        int ind = 0;
        for (String str : expressions) {
            validate(str);
        }
        
        for (String str : expressions) {
            String res = convert(str);
            if (res != null) result.add(res);
        }
        return result.toArray(new String[0]);
    }

    void validate(String expr) {

        StringTokenizer st = new StringTokenizer(expr);
        String A = st.nextToken();
        String command = st.nextToken();
        String B = st.nextToken();
        st.nextToken();
        String C = st.nextToken();

        for (int i = 2; i <= 9; i++) {
            int convA = 0, convB = 0, convC = 0;
            try {
                convA = Integer.parseInt(A, i);
                convB = Integer.parseInt(B, i);
                if (!"X".equals(C)) convC = Integer.parseInt(C, i);
            } catch (NumberFormatException e) {
                bools[i] = false;
                continue;
            }
            if ("X".equals(C)) continue;
            if ("+".equals(command)) {
                if (convA + convB != convC)
                    bools[i] = false;
            } else {
                if (convA - convB != convC)
                    bools[i] = false;
            }
        }
    }

    String convert(String expr) {
        if (expr.charAt(expr.length() - 1) != 'X') return null;

        StringTokenizer st = new StringTokenizer(expr);
        String A = st.nextToken();
        String command = st.nextToken();
        String B = st.nextToken();
        st.nextToken();
        st.nextToken();

        String res = "";
        for (int i = 2; i <= 9; i++) {
            if ("?".equals(res)) break;
            if (!bools[i]) continue;

            int convA = 0, convB = 0;
            try {
                convA = Integer.parseInt(A, i);
                convB = Integer.parseInt(B, i);
            } catch (NumberFormatException e) {
                continue;
            }
            if ("+".equals(command)) {
                String convC = Integer.toString(convA + convB, i);
                if ("".equals(res)) res = convC;
                else if (!res.equals(convC)) res = "?";
            } else {
                String convC = Integer.toString(convA - convB, i);
                if ("".equals(res)) res = convC;
                else if (!res.equals(convC)) res = "?";
            }
        }

        return A + " " + command + " " + B + " = " + res;
    }
}