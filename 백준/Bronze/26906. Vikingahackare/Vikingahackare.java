import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String v = st.nextToken();
			String k = st.nextToken();
			map.put(k, v);
		}
		
		String s = br.readLine();
		for(int i = 0; i < s.length(); i += 4) {
			String key = s.substring(i, i + 4);
			sb.append(map.getOrDefault(key, "?"));
		}
		
		System.out.println(sb);
		
	}

}