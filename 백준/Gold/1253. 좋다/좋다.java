import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] arr;
	static int count = 0;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		if (N <= 2) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;
			if(start == i)
				start++;
			if(end == i)
				end--;
			
			while (start < N && end >= 0 && !(start == end)) {
				sum = arr[start] + arr[end];
				if (sum == arr[i]) {
					count++;
					break;
				}
				
				if (sum > arr[i])
					end = (end - 1 == i) ? end - 2 : end - 1;
				else
					start = (start + 1 == i) ? start + 2 : start + 1;
			}
		}

		System.out.println(count);

	}

}