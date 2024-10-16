import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < n; i++)
			set.add(br.readLine());
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			if(set.contains(br.readLine()))
				cnt++;
		}
		System.out.println(cnt);
		
	}

}