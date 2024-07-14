import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			int count = Integer.parseInt(br.readLine());
			for(int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int v = Integer.parseInt(st.nextToken());
				if(c == 'I') {
					if(map.containsKey(v))
						map.put(v, map.get(v) + 1);
					else
						map.put(v, 1);
				} else {
					if(map.size() == 0)
						continue;
					if(v == 1) {
						if(map.get(map.lastKey()) == 1)
							map.remove(map.lastKey());
						else {
							map.put(map.lastKey(), map.get(map.lastKey()) - 1);
						}
					} else {
						if(map.get(map.firstKey()) == 1)
							map.remove(map.firstKey());
						else {
							map.put(map.firstKey(), map.get(map.firstKey()) - 1);
						}
					}
				}
				
			}
			if(map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				sb.append(map.lastKey()).append(" ");
				sb.append(map.firstKey()).append("\n");
			}
			
		}
		System.out.print(sb.toString().trim());
	}

}
