import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		Collections.sort(list);
		for (int i = 0; i < N; i++)
			arr[i] = list.get(i);

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