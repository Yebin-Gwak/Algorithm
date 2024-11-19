import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Set<String> set = new HashSet<>();
		set.add("he");
		set.add("him");
		set.add("she");
		set.add("her");
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(set.contains(st.nextToken())) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}