import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i = 0; i < N; i++)
			cnt += Integer.parseInt(st.nextToken());
		if(cnt == 0)
			System.out.println("Stay");
		else if(cnt > 0)
			System.out.println("Right");
		else
			System.out.println("Left");
	}
}