import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("#"))
				break;
			int cnt = 0;
			for(char c : s.toLowerCase().toCharArray()) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					cnt++;
			}
			sb.append(cnt + "\n");
		}
		System.out.print(sb);
	}
}