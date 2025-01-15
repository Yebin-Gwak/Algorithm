import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String S = br.readLine();
		int Q = Integer.parseInt(br.readLine());
		int[][] arr = new int[S.length()][26];

		arr[0][S.charAt(0) - 'a']++;
		for(int i = 1; i < S.length(); i++) {
			for(int j = 0; j < 26; j++) {
				arr[i][j] = arr[i - 1][j];
			}
			arr[i][S.charAt(i) - 'a']++;
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int c = st.nextToken().charAt(0) - 'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append((start == 0) ? arr[end][c] : arr[end][c] - arr[start - 1][c]).append("\n");
		}
		
		System.out.print(sb.toString());
	}

}