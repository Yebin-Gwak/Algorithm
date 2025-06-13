import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, String> map = Map.of(
				"Algorithm", "204",
				"DataAnalysis", "207",
				"ArtificialIntelligence", "302",
				"CyberSecurity", "B101",
				"Network", "303",
				"Startup", "501",
				"TestStrategy", "105"
				);
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++)
			sb.append(map.get(br.readLine()) + "\n");
		
		System.out.print(sb.toString());
		
	}

}