import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        
        int sum = 0;
        for(String ch : n.split("")) {
            sum += Integer.parseInt(ch);
        }
        System.out.println(sum);
    }
}