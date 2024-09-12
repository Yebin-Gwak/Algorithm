import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		char a = br.readLine().charAt(0);
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int k = st.nextToken().charAt(0);
			if(k == a)
				cnt++;
		}
		System.out.println(cnt);
	}
}