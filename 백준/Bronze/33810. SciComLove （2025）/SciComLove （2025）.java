import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = "SciComLove".toCharArray();
		char[] s = br.readLine().toCharArray();
		int cnt = 0;
		for(int i = 0; i < 10; i++)
			cnt += (arr[i] != s[i]) ? 1 : 0;
		System.out.println(cnt);
	}
}