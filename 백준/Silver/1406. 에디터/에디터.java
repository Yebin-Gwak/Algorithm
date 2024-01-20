import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> stkL = new Stack<>();
		Stack<Character> stkR = new Stack<>();

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			stkL.add(str.charAt(i));
		}
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			String cmd = br.readLine();

			switch (cmd.charAt(0)) {
			case 'L': {
				if (stkL.size() != 0)
					stkR.add(stkL.pop());
				break;
			}

			case 'D': {
				if (stkR.size() != 0)
					stkL.add(stkR.pop());
				break;
			}

			case 'B': {
				if (stkL.size() != 0)
					stkL.pop();
				break;
			}

			case 'P': {
				stkL.add(cmd.charAt(2));
				break;
			}

			}

		}
		while(!stkR.empty()) {
			stkL.add(stkR.pop());
		}

		while(!stkL.empty()) {
			stkR.add(stkL.pop());
		}

		while(!stkR.empty()) {
			bw.write(stkR.pop());
		}
		br.close();
		bw.close();
	}

}