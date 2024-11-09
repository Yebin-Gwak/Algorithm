import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int[] arr = new int[s.length()];
		
		int n = Integer.parseInt(s);
		for(int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}
		Arrays.sort(arr);
		for(int a : arr) {
			sb.append(a);
		}
		System.out.println(sb.reverse().toString());
	}
}