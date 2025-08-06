import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> map = new HashMap<>();
		map.put("CU", "see you\n");
		map.put(":-)", "I’m happy\n");
		map.put(":-(", "I’m unhappy\n");
		map.put(";-)", "wink\n");
		map.put(":-P", "stick out my tongue\n");
		map.put("(~.~)", "sleepy\n");
		map.put("TA", "totally awesome\n");
		map.put("CCC", "Canadian Computing Competition\n");
		map.put("CUZ", "because\n");
		map.put("TY", "thank-you\n");
		map.put("YW", "you’re welcome\n");
		map.put("TTYL", "talk to you later\n");
		
		while(true) {
			String s = br.readLine();
			sb.append((map.containsKey(s) ? map.get(s) : s + "\n"));
			if(s.equals("TTYL"))
				break;
		}
		
		System.out.print(sb.toString());
		
	}
}