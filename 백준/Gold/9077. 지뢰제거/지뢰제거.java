import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.putIfAbsent(x, new TreeSet<Integer>());
				map.get(x).add(y);
			}
			
			for(Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
				int x = entry.getKey();
				TreeSet<Integer> set = entry.getValue();
				for(int i = x - 9; i <= x; i++) {
				for(int y : set) {
					for(int j = y - 9; j <= y; j++) {
						int cnt = 0;
						
						SortedMap<Integer, TreeSet<Integer>> subMap = map.subMap(i, i + 11);
						for(TreeSet<Integer> rangeX : subMap.values()) {
							SortedSet<Integer> subSet = rangeX.subSet(j, j + 11);
							cnt += subSet.size();
						}
						max = Math.max(max, cnt);
					}
				}
				}
			}
			
			sb.append(max + "\n");
			
		}
		System.out.print(sb);
	}
}
