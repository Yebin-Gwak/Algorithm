import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static class Folder{
		String parent;
		String name;
		HashSet<String> folder = new HashSet<>();
		HashSet<String> file = new HashSet<>();
		
		public Folder(String parent, String name) {
			this.parent = parent;
			this.name = name;
		}
		
		public void insert(String s) {
			file.add(s);
		}
		
		public void move(String to) {
			for(String s : folder) {
				folders.get(s).parent = to;
				folders.get(to).folder.add(s);
			}
			for(String s : file)
				folders.get(to).file.add(s);
			folder.clear();
			file.clear();
			folders.get(parent).folder.remove(name);
		}

		public void getCount(Result result) {
			result.cnt += file.size();
			for(String s : file)
				result.names.add(s);
			
			for(String s : folder) {
				if(folders.get(s).parent == null)
					continue;
				folders.get(s).getCount(result);
			}
		}

	}
	
	static class Result{
		HashSet<String> names = new HashSet<>();
		int cnt = 0;
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
		
		for(Folder f : folders.values()) {
			if(f.parent == null)
				continue;
			folders.get(f.parent).folder.add(f.name);
		}
		
		while(!deque.isEmpty()) {
			String[] arr = deque.poll();
			folders.get(arr[0]).insert(arr[1]);
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			String[] arr1 = st.nextToken().split("/");
			String[] arr2 = st.nextToken().split("/");
			
			Folder from = folders.get(arr1[arr1.length - 1]);
			String to = arr2[arr2.length - 1];
			
			from.move(to);
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			
			String[] arr = br.readLine().split("/");
			String folder = arr[arr.length - 1];
			
			Result result = new Result();
			folders.get(folder).getCount(result);
			sb.append(result.names.size() + " " + result.cnt).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}

}