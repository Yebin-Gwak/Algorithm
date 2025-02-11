import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static class Folder{
		HashSet<String> set = new HashSet<>();
		
		String parent;
		String name;
		int cntFile = 0;
		
		public Folder(String parent, String name) {
			this.parent = parent;
			this.name = name;
		}
		
		public void insert(String s) {
			if(!set.contains(s))
				set.add(s);
			cntFile++;
			if(parent != null)
				folders.get(parent).insert(s);
		}
		
	}
	
	static HashMap<String, Folder> folders = new HashMap<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		folders.put("main", new Folder(null, "main"));
		
		ArrayDeque<String[]> deque = new ArrayDeque<>();
		
		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			String name = st.nextToken();
			int cmd = Integer.parseInt(st.nextToken());
			
			if(cmd == 1)
				folders.put(name, new Folder(parent, name));
			else
				deque.add(new String[] {parent, name});
		}
		
		while(!deque.isEmpty()) {
			String[] arr = deque.poll();
			folders.get(arr[0]).insert(arr[1]);
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			String[] arr = br.readLine().split("/");
			String folder = arr[arr.length - 1];
			sb.append(folders.get(folder).set.size() + " " + folders.get(folder).cntFile).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}