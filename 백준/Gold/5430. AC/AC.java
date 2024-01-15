import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < t; i++) {
			String commands = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String numbers = br.readLine().replaceAll("\\[|\\]", "");
			LinkedList<String> q = new LinkedList<>();
			boolean emptyFlag = true;
			boolean flag = true;
			if (n != 0)
				for (String num : numbers.split(",")) q.add(num);
			for (String command : commands.split("")) {
				if (command.equals("R")) {
					flag = !flag;
				} else {
					if (q.isEmpty()) {
						emptyFlag = false;
						break;
					} else {
						if (flag) {
							q.pollFirst();
						} else {
							q.pollLast();
						}					
					}
				}
			}
			if (emptyFlag) {
				sb.append("[");
				if(flag) {
					for (String num : q)
						sb.append(num).append(",");
				} else {
					while (!q.isEmpty())
						sb.append(q.pollLast()).append(",");
				}
				if (sb.lastIndexOf(",") == sb.length()-1) sb.deleteCharAt(sb.length()-1);
				sb.append("]\n");
			} else {
				sb.append("error\n");
			}
		}
		System.out.print(sb.toString());
	}
}