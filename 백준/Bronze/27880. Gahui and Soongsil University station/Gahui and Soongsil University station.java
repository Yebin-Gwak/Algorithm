import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum = 0;
		while(true) {
			String s = br.readLine();
			if(s == null)
				break;
			st = new StringTokenizer(s);
			if(st.nextToken().equals("Es"))
				sum += Integer.parseInt(st.nextToken()) * 21;
			else
				sum += Integer.parseInt(st.nextToken()) * 17;
		}
		
		System.out.println(sum);
	}
}