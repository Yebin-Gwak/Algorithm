import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] arr = new boolean[250_000];
		arr[0] = true;
		arr[1] = true;

		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == false) {
				for (int j = i * 2; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			int ans = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (!arr[i])
					ans++;
			}
			sb.append(ans + "\n");
		}

		System.out.println(sb.toString());
	}

}