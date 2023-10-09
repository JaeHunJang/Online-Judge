import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = n + "";
        if(n%2 == 0) 
            s += " is even";
        else
            s += " is odd";
            
        System.out.print(s);
    }
}