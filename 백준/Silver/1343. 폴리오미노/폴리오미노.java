import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String data = br.readLine();
		
		int count = 0;
		for(int i = 0; i < data.length(); i++) {
			if(data.charAt(i) == '.') {
				if(count == 0)
					sb.append('.');
				else {
					if(count % 2 != 0) {
						System.out.println(-1);
						return;
					}else {
						for(int j = 0; j < (count / 4) * 4; j++)
							sb.append('A');
						count %= 4;
						for(int j = 0; j < (count / 2) * 2; j++)
							sb.append('B');
						count = 0;
					}
					sb.append('.');
				}
			}
			else
				count++;
		}
		
		if(count % 2 != 0) {
			System.out.println(-1);
			return;
		}else {
			for(int i = 0; i < (count / 4) * 4; i++)
				sb.append('A');
			count %= 4;
			for(int i = 0; i < (count / 2) * 2; i++)
				sb.append('B');
			count = 0;
		}
		
		System.out.println(sb.toString());

	}
}