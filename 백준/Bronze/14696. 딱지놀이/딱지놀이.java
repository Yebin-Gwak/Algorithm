import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int[][] arr = new int[2][5];
			String ans = "D";
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				int len = Integer.parseInt(st.nextToken());
				for(int j = 0; j < len; j++) {
					int index = Integer.parseInt(st.nextToken());
					arr[i][index]++;
				}
				
			}
			
			for(int i = 4; i >= 0; i--) {
				if(arr[0][i] == arr[1][i])
					continue;
				else if(arr[0][i] > arr[1][i]) {
					ans = "A";
					break;
				}
				else if (arr[0][i] < arr[1][i]) {
					ans = "B";
					break;
				}
			}
			System.out.println(ans);
			
		}
		

	}

}