import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			list.add(Long.parseLong(st.nextToken()));
		Collections.sort(list);
		for (int i = 0; i < N; i++)
			arr[i] = list.get(i);

		long ans = Long.MAX_VALUE;
		int start, middle, end;

		long leftValue = 0;
		long middleValue = 0;
		long rightValue = 0;

		for(int i = 0; i < N- 2; i++) {
			start = i;
			middle = i + 1;
			end = N - 1;
			
			while (middle != end) {
				long sum = arr[start] + arr[middle] + arr[end];
				if (Math.abs(sum) < ans) {
					ans = Math.abs(sum);
					leftValue = arr[start];
					middleValue = arr[middle];
					rightValue = arr[end];
					if (ans == 0)
						break;
				}
				if (sum < 0)
					middle++;
				else
					end--;
				
			}
		}
		System.out.println(leftValue + " " + middleValue + " " + rightValue);
	}
}