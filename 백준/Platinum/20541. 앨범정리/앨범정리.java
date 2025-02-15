import java.util.*;
import java.io.*;

public class Main {
	
	static class Album{
		Album parent;
		String name;
		TreeMap<String, Album> albums = new TreeMap<>();
		TreeSet<String> files = new TreeSet<>();
		
		public Album(Album parent, String name) {
			this.parent = parent;
			this.name = name;
		}
		
		public void mkAlb(String s) {
			if(albums.containsKey(s)) {
				sb.append("duplicated album name").append("\n");
				return;
			}
			Album a = new Album(this, s);
			albums.put(s, a);
		}
		
		public void rmAlb(String s) {
			albumCnt = 0;
			fileCnt = 0;
			
			char cmd = s.charAt(0);
			
			if(cmd == '-') {
				if(!albums.isEmpty()) {
					albumCnt++;
					albums.get(albums.firstKey()).removeAll();;
					albums.remove(albums.firstKey());
				}
			} else if(cmd == '0') {
				albumCnt += albums.size();
				for(Album a : albums.values())
					a.removeAll();
				albums.clear();
			} else if(cmd == '1') {
				if(!albums.isEmpty()) {
					albumCnt++;
					albums.get(albums.lastKey()).removeAll();
					albums.remove(albums.lastKey());
				}
			}else {
				if(albums.containsKey(s)) {
					albumCnt++;
					albums.get(s).removeAll();;
					albums.remove(s);
				}
			}
			
			sb.append(albumCnt + " " + fileCnt).append("\n");
		}

		private void removeAll() {
			albumCnt += albums.size();
			fileCnt += files.size();
			for(Album a : albums.values())
				a.removeAll();
		}
		
		public void insert(String s) {
			if(files.contains(s)) {
				sb.append("duplicated photo name").append("\n");
				return;
			}
			files.add(s);
		}
		
		public void delete(String s) {
			fileCnt = 0;
			char cmd = s.charAt(0);
			if(cmd == '-') {
				if(!files.isEmpty()) {
					files.remove(files.first());
					fileCnt++;
				}
			}else if(cmd == '0') {
				fileCnt += files.size();
				files.clear();
			}else if(cmd == '1') {
				if(!files.isEmpty()) {
					files.remove(files.last());
					fileCnt++;
				}
			}else {
				fileCnt += (files.remove(s)) ? 1 : 0;
			}
			
			sb.append(fileCnt).append("\n");
		}
		
		public void ca(String s) {
			char cmd = s.charAt(0);
			if(cmd == '.') {
				if(parent != null)
					now = parent;
			}else if(cmd == '/') {
				now = root;
			}else {
				if(albums.containsKey(s))
					now = albums.get(s);
			}
			sb.append(now.name).append("\n");
		}
		
	}
	
	static StringBuilder sb = new StringBuilder();
	static int albumCnt = 0;
	static int fileCnt = 0;
	static Album root;
	static Album now;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		root = new Album(null, "album");
		now = root;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			String s = st.nextToken();
			if(cmd == 'm')
				now.mkAlb(s);
			else if(cmd == 'r')
				now.rmAlb(s);
			else if(cmd == 'i')
				now.insert(s);
			else if(cmd == 'd')
				now.delete(s);
			else
				now.ca(s);
		}
		
		System.out.print(sb.toString());
	}

}