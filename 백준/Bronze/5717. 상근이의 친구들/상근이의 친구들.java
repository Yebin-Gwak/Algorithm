import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			if(a == 0)
				break;
			else
				sb.append(a + "\n");
		}
		
		System.out.print(sb.toString());
		
	}

}