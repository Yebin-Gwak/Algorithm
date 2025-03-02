import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == -1)
				break;
			ans += n;
		}
		System.out.println(ans);
	}
}