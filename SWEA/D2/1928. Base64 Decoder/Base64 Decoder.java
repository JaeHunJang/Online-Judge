import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        char[] ascii = { 'A', 'B', 'C', 'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};
        List<String> list = new ArrayList();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case + " ");
            String s = sc.next();
            String convert = "";
            list.clear();
            for(char ch : s.toCharArray()) {
                for(int i = 0; i < ascii.length; i++) {
                    if(ascii[i] == ch) {
                        convert += String.format("%6s",Integer.toString(i,2)).replaceAll(" ", "0");
                        break;
                    }
                }
                if(convert.length() >= 8) {
                    list.add((char)Integer.parseInt(convert.substring(0, 8), 2)+"");
                    convert = convert.substring(8);
                }
            }
            if (!convert.equals("")) list.add((char)Integer.parseInt(convert, 2)+"");
            System.out.println(String.join("", list));
        }
	}
}