import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0)
				break;
			int now = Integer.parseInt(st.nextToken());
			for(int i = 0; i < N - 1; i++) {
				int next = Integer.parseInt(st.nextToken());
				if(now == next)
					continue;
				sb.append(now + " ");
				now = next;
			}
			sb.append(now + " $\n");
		}
		
		System.out.print(sb.toString());

	}

}