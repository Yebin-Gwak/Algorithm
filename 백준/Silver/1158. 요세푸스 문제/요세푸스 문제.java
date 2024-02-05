import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		LinkedList<Integer> arr = new LinkedList<>();
		List<Integer> ans = new ArrayList<Integer>();
		int index = K-1;
		
		for(int i = 1; i <= N; i++) {
			 arr.addLast(i);
		}
	
		while(!arr.isEmpty()) {
			while(index > arr.size()-1) {
				index -= arr.size();
			}
			ans.add(arr.get(index));
			arr.remove(index);
			index += K-1;
		}
		
		sb.append("<");
		for(int i = 0; i < ans.size()-1; i++) {
			sb.append(ans.get(i));
			sb.append(", ");
		}
		sb.append(ans.get(ans.size()-1));
		sb.append(">");
		System.out.println(sb.toString());
	}
}