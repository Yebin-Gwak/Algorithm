import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();			
			LinkedList<Character> arr = new LinkedList<>();
			ListIterator<Character> iter = arr.listIterator();
			String cmd = br.readLine();
			for(int i = 0; i < cmd.length(); i++) {
				switch(cmd.charAt(i)) {
				
				case '<':
					if(iter.hasPrevious()) iter.previous();
					break;
					
				case '>':
					if(iter.hasNext()) iter.next();
					break;
					
				case '-':
					if(iter.hasPrevious()) {
						iter.previous();
						iter.remove();
					}
					break;
					
				default:
					iter.add(cmd.charAt(i));
					
				}
			}
			
			for(char c : arr) {
				sb.append(c);
			}
			System.out.println(sb);
			
			
		}
	}
}