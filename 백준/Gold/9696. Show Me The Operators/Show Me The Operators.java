import java.util.*;
import java.io.*;

public class Main {
	static Deque<Integer> numbers;
	static Deque<Character> plusMinus;
	static Deque<Character> mulDiv;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			numbers = new ArrayDeque<Integer>();
			plusMinus = new ArrayDeque<Character>();
			mulDiv = new ArrayDeque<Character>();
			numbers.add(Integer.parseInt(st.nextToken()));
			
			sb.append("Case #" + tc + ": ");

			while(true) {
				char oper = st.nextToken().charAt(0);
				if(oper == '+' || oper == '-')
					plusMinus.add(oper);
				else 
					sb.append(oper + " ");
				
				
				int num = Integer.parseInt(st.nextToken());
				if(oper == '*' || oper == '/') {
					int prev = numbers.pollLast();
					if(oper == '*')
						prev *= num;
					else {
						if(num == 0)
							prev = num;
						else
							prev /= num;
					}
					
					numbers.add(prev);
				}
				else
					numbers.add(num);
				
				if(!st.hasMoreTokens())
					break;
			}
			
			int now = numbers.poll();
			
			while(!numbers.isEmpty()) {
				char oper = plusMinus.poll();

				sb.append(oper + " ");
				
				int next = numbers.poll();
				if(oper == '+')
					now += next;
				else
					now -= next;
			}
			
			sb.append(now + "\n");
			
		}
		System.out.print(sb.toString());

	}

}