import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;

		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			if(a == 0 && a == b && a == c && a == d) {
				break;
			}
			
			int k = c - b;
			int q = d - a;
			sb.append(k + " " + q).append("\n");
		}
		System.out.println(sb.toString());
	}
}