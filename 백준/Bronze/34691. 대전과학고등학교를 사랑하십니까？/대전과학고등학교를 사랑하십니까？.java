import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String s = br.readLine();
			if(s.equals("end"))
				break;
			if(s.equals("animal"))
				sb.append("Panthera tigris");
			else if(s.equals("tree"))
				sb.append("Pinus densiflora");
			else if(s.equals("flower"))
				sb.append("Forsythia koreana");
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}
