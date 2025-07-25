import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, String> map = Map.of(
				1, "11\nA B C D E F G H J L M",
				2, "9\nA C E F G H I L M",
				3, "9\nA C E F G H I L M",
				4, "9\nA B C E F G H L M",
				5, "8\nA C E F G H L M",
				6, "8\nA C E F G H L M",
				7, "8\nA C E F G H L M",
				8, "8\nA C E F G H L M",
				9, "8\nA C E F G H L M",
				10, "8\nA B C F G H L M"
				);
		System.out.print(map.get(Integer.parseInt(br.readLine())));
	}

}