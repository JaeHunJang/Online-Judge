import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws Exception	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
		for (int i = 0; i < n; i++) {
			int count = 0;
			String answer = "NO";
			for (String ch : br.readLine().split("")) {
				if("(".equals(ch)) {
					count++;
				} else if(")".equals(ch)){
					count--;
				}
				if (count < 0) break;
			}
			
			if (count == 0) {
				answer = "YES";
			}
			
			System.out.println(answer);
		}
	}
}