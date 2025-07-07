import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String s;
		while(true) {
			s = br.readLine();
			if(s == null)
				break;
			st = new StringTokenizer(s);
			int N = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			sb.append(V / (N + 1) + "\n");
		}
		
		System.out.print(sb.toString());
	}

}