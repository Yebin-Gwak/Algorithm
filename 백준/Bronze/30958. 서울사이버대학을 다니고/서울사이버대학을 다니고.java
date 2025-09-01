import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[26];
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			for(char c : s.toCharArray()) {
				if(c - 'a' < 0)
					continue;
				arr[c - 'a']++;
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[25]);
	}
}