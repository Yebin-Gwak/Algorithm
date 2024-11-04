import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < T; i++) {
			int ans = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int q = Integer.parseInt(st.nextToken());
				ans += p * q;
			}
			System.out.println(ans);
		}
	}
}