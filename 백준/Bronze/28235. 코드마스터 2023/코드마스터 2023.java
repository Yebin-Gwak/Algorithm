import java.util.*;

public class Main {
	public static void main(String[] args) {
		String n = new Scanner(System.in).next();
		Map<String, String> m = Map.of(
			"SONGDO", "HIGHSCHOOL",
			"CODE", "MASTER",
			"2023", "0611",
			"ALGORITHM", "CONTEST"
		);
		System.out.println(m.get(n));
	}
}