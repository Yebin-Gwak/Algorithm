import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("Poblano", 1500);
		map.put("Mirasol", 6000);
		map.put("Serrano", 15500);
		map.put("Cayenne", 40000);
		map.put("Thai", 75000);
		map.put("Habanero", 125000);
		int n = sc.nextInt();
		int answer = 0;
		for(int i = 0; i < n; i++)
			answer += map.get(sc.next());
		System.out.println(answer);
	}
}