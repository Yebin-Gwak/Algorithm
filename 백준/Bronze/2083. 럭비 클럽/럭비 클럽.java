import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			if(s.equals("# 0 0"))
				break;
			st = new StringTokenizer(s);
			sb.append(st.nextToken() + " ");
			sb.append((Integer.parseInt(st.nextToken()) > 17 || 
					Integer.parseInt(st.nextToken()) > 79) ? "Senior" : "Junior").append("\n");
		}
		System.out.print(sb);
	}
}