import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		int N = Integer.parseInt(s);
		if(!s.contains("7"))
			System.out.println(N % 7 == 0 ? 1 : 0);
		else
			System.out.println(N % 7 == 0 ? 3 : 2);
	}
}