import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> m = new HashMap<>(Map.of(
		        "1",  "12 1600",
		        "2",  "11 894",
		        "3",  "11 1327",
		        "4",  "10 1311",
		        "5",  "9 1004",
		        "6",  "9 1178",
		        "7",  "9 1357",
		        "8",  "8 837",
		        "9",  "7 1055",
		        "10", "6 556"
		));
		m.put("11", "6 773");
		System.out.println(m.get(br.readLine()));
	}

}