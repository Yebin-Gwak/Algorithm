import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		
		int MOD = 1000000007;
		long w = 0;
		long wh = 0;
		long whe = 0;
		long whee = 0;
		
		for(int i = 0; i < N; i++) {
			char c = s.charAt(i);
			if(c == 'W')
				w++;
			else if(c == 'H')
				wh += w;
			else if(c == 'E') {
				whee *= 2; // 기존 whee 뒤에 e를 추가로 붙인 경우
				whee += whe; // 기존 wh 뒤에 e 붙인 경우
				whee %= MOD;
				whe += wh;
			}
		}

		System.out.println(whee);
	}

}
