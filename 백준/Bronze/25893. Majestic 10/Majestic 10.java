import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[] {"zilch", "double", "double-double", "triple-double"};
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			sb.append(s + "\n");
			st = new StringTokenizer(s);
			int cnt = 0;
			for(int j = 0; j < 3; j++)
				cnt += Integer.parseInt(st.nextToken()) > 9 ? 1 : 0;
			sb.append(arr[cnt] + "\n\n"); 
		}
		
		System.out.print(sb.toString().trim());
		
	}
}