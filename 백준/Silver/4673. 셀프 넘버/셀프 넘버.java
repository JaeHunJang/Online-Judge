import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int limit = 10000;
        boolean[] isGenerated = new boolean[limit + 1];

        // 생성자가 있는 수
        for (int i = 1; i <= limit; i++) {
            int num = d(i);
            if (num <= limit) {
                isGenerated[num] = true;
            }
        }

        // 생성자가 없는 수
        for (int i = 1; i <= limit; i++) {
            if (!isGenerated[i]) {
                System.out.println(i);
            }
        }
    }
    public static int d(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10; 
            n /= 10;
        }
        return sum;
    }

}
