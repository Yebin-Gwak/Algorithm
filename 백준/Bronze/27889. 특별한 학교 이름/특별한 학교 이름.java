import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<>();
		map.put("NLCS", "North London Collegiate School");
		map.put("BHA", "Branksome Hall Asia");
		map.put("KIS", "Korea International School");
		map.put("SJA", "St. Johnsbury Academy");
		System.out.println(map.get(sc.next()));
	}
}