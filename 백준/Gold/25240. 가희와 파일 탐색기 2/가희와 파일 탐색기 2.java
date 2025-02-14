import java.util.*;
import java.io.*;

public class Main {
	
	static class File{
		String owner;
		HashSet<String> group;
		boolean[][] permissions = new boolean[3][3];
		
		public File(String owner, String group, String permission) {
			this.owner = owner;
			this.group = groups.get(group);
			
			for(int i = 0; i < 3; i++) {
				int p = permission.charAt(i) - '0';
				if(p == 0) continue;
				if(p == 4 || p == 5 || p == 6 || p == 7)
					permissions[i][0] = true;
				if(p == 2 || p == 3 || p == 6 || p == 7)
					permissions[i][1] = true;
				if(p == 1 || p == 3 || p ==5 || p == 7)
					permissions[i][2] = true;
			}
			
		}
		
		public int check(String user, char cmd) {
			if(owner.equals(user))
				return getValue(0, cmd);
			if(group.contains(user))
				return getValue(1, cmd);
			return getValue(2, cmd);
		}

		private int getValue(int p, char cmd) {
			int c = 0;
			if(cmd == 'W') c = 1;
			else if(cmd == 'X') c = 2;
			return (permissions[p][c]) ? 1 : 0;
		}
		
	}

	static HashMap<String, HashSet<String>> groups = new HashMap<>();
	static HashMap<String, File> files = new HashMap<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String user = st.nextToken();
			groups.putIfAbsent(user, new HashSet<>());
			groups.get(user).add(user);
			if(!st.hasMoreTokens())
				continue;
			st = new StringTokenizer(st.nextToken(), ",");
			
			while(st.hasMoreTokens()) {
				String group = st.nextToken();
				groups.putIfAbsent(group, new HashSet<>());
				groups.get(group).add(user);
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String file = st.nextToken();
			String permission = st.nextToken();
			String owner = st.nextToken();
			String group = st.nextToken();
			files.put(file, new File(owner, group, permission));
		}
		
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			String user = st.nextToken();
			String file = st.nextToken();
			char cmd = st.nextToken().charAt(0);
			sb.append(files.get(file).check(user, cmd)).append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	
}