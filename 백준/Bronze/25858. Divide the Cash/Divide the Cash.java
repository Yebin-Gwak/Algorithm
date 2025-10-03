import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += arr[i] = Integer.parseInt(br.readLine());
		v /= sum;
		for(int i = 0; i < N; i++)
			sb.append(v * arr[i] + "\n");
		System.out.println(sb);
	}
}