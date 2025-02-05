import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static HashMap<String, ArrayList<String>> list = new HashMap<>();
	static TreeSet<String> ans = new TreeSet<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		list.put("Baba", new ArrayList<>());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			st.nextToken();
			String b = st.nextToken();
			
			list.putIfAbsent(a, new ArrayList<>());
			list.putIfAbsent(b, new ArrayList<>());
			list.get(a).add(b); 
		}
		
		ans.add("Baba");
		dfs("Baba");
		ans.remove("Baba");
		
		for(String s : ans)
			sb.append(s + "\n");
		
		System.out.print(sb.toString().trim());

		
	}
	private static void dfs(String s) {
		for(String next : list.get(s)) {
			if(!ans.contains(next)) {
				ans.add(next);
				dfs(next);
			}
		}
		
	}

}