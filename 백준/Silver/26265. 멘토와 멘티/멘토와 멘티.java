import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		Arrays.sort(arr, (o1, o2) -> o2[1].compareTo(o1[1]));
		Arrays.sort(arr, (o1, o2) -> o1[0].compareTo(o2[0]));
		for(int i = 0; i < N; i++)
			sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		System.out.print(sb);
	}
}