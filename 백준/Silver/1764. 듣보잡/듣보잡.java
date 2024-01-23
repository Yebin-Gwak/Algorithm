import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<String>();
		ArrayList<String> arr = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		

		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		for (int j = 0; j < m; j++) {
			String data = br.readLine();
			if (set.contains(data)) {
				arr.add(data);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (String s : arr)
			System.out.println(s);

	}

}