import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Integer> map = new TreeMap<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}

		String ans = "";
		int max = 0;
		for (Map.Entry<String, Integer> key : map.entrySet()) {
			if (key.getValue() > max) {
				max = key.getValue();
				ans = key.getKey();
			}
		}
		System.out.println(ans);
	}
}