import java.util.*;
import java.io.*;

public class Main {
	
	static class Folder{
		String parent;
		String name;
		HashSet<String> folders = new HashSet<>();
		HashSet<String> files = new HashSet<>();
		
		public Folder(String parent, String name) {
			this.parent = parent;
			this.name = name;
		}
		
		public void insert(String s, int cmd) {
			if(cmd == 0)
				files.add(s);
			else {
				folders.add(s);
				computer.get(s).parent = name;
			}
		}
		
		public void move(String to) {
			for(String s : folders) {
				computer.get(s).parent = to;
				computer.get(to).folders.add(s);
			}
			for(String s : files)
				computer.get(to).files.add(s);
			computer.get(parent).folders.remove(name);
		}

		public void getCount() {
			cnt += files.size();
			for(String s : files)
				set.add(s);
			
			for(String s : folders) {
				if(computer.get(s).parent == null)
					continue;
				computer.get(s).getCount();
			}
		}

	}

	static HashMap<String, Folder> computer = new HashMap<>();
	static HashSet<String> set = new HashSet<>();
	static int cnt = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		computer.put("main", new Folder(null, "main"));

		for(int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			String parent = st.nextToken();
			String name = st.nextToken();
			int cmd = Integer.parseInt(st.nextToken());
			
			computer.putIfAbsent(parent, new Folder(null, parent));
			if(cmd == 1)
				computer.putIfAbsent(name, new Folder(null, name));
			computer.get(parent).insert(name, cmd);
		}
	
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			String[] arr1 = st.nextToken().split("/");
			String[] arr2 = st.nextToken().split("/");
			
			Folder from = computer.get(arr1[arr1.length - 1]);
			String to = arr2[arr2.length - 1];
			
			from.move(to);
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			String[] arr = br.readLine().split("/");
			String folder = arr[arr.length - 1];
			set.clear();
			cnt = 0;
			
			computer.get(folder).getCount();
			sb.append(set.size() + " " + cnt).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}