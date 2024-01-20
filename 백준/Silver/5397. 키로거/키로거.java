import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 0; tc < T; tc++) {
			Stack<Character> stkL = new Stack<>();
			Stack<Character> stkR = new Stack<>();

			String cmd = br.readLine();
			for (int i = 0; i < cmd.length(); i++) {
				char c = cmd.charAt(i);

				switch (c) {
				case '<': 
					if(!stkL.isEmpty())
						stkR.add(stkL.pop());
					break;
					
				case '>':
					if(!stkR.isEmpty())
						stkL.add(stkR.pop());
					break;
					
				case '-':
					if(!stkL.isEmpty())
						stkL.pop();
					break;
					
				default:
					stkL.add(c);
					break;
				}
			}
			
			while(!stkR.isEmpty())
				stkL.add(stkR.pop());
			
			while(!stkL.isEmpty())
				stkR.add(stkL.pop());
			
			while(!stkR.isEmpty())
				bw.write(stkR.pop());
			
			bw.write("\n");
		}
		br.close();
		bw.close();

	}

}