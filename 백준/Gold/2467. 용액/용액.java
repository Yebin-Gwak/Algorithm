import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int ans = Integer.MAX_VALUE;
		int start = 0;
		int end = N - 1;
		int leftValue = 0;
		int rightValue = 0;

		while (start != end) {
			int sum = arr[start] + arr[end];
			if (Math.abs(sum) < ans) {
				ans = Math.abs(sum);
				leftValue = arr[start];
				rightValue = arr[end];
				if (ans == 0)
					break;
			}
			if (sum < 0)
				start++;
			else
				end--;

		}
		System.out.println(leftValue + " " + rightValue);
	}
}
