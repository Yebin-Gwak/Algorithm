import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int[] times = new int[2];
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 3; k++) {
					times[j] = times[j] * 60 + Integer.parseInt(st.nextToken());
				}
			}
			int t = times[1] - times[0];
			int s = t % 60;
			t /= 60;
			int m = t % 60;
			int h = t / 60;
			System.out.println(h + " " + m + " " + s);
		}
		
	}
}