import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		long[] arr = new long[101];
		arr[1] = arr[2] = arr[3] = 1;
		for(int i = 4; i <= 100; i++)
			arr[i] = arr[i-3] + arr[i-2];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N] + "\n");
		}
		System.out.println(sb.toString());	
	}
}