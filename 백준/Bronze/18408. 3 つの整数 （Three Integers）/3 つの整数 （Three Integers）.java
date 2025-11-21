import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int o = 0;
		int t = 0;
		for(int i = 0; i < 3; i++) {
			if(Integer.parseInt(st.nextToken()) == 1)
				o++;
			else
				t++;
		}
		System.out.println(o > t ? 1 : 2);
			
	}
}