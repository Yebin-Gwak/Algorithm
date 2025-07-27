import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int cnt = 0;
		for(int i = 0; i < N; i++)
			if(Integer.parseInt(br.readLine()) % 2 == 1)
				cnt++;
		System.out.println(cnt);
	}
}