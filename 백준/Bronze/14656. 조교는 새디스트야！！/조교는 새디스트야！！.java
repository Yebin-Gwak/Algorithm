import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(i != Integer.parseInt(st.nextToken())) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}