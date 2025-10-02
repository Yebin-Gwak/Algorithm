import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[128];
		arr['A'] = arr['a'] = arr['b'] = arr['D'] = arr['d'] = arr['e'] = arr['g'] = arr['O'] = arr['o'] = arr['P'] = arr['p'] = arr['Q'] = arr['q'] = arr['R'] = 1;
		arr['B'] = 2;
		int ans = 0;
		String s = br.readLine();
		for (char c : s.toCharArray()) {
			if (c == '@')
				ans++;
			else
				ans += arr[c];
		}

		System.out.println(ans);
	}
}