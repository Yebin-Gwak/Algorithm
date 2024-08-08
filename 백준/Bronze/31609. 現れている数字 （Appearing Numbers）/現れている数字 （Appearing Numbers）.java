import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> set = new TreeSet();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			set.add(sc.nextInt());
		for(Integer x : set)
			System.out.println(x);
	}
}