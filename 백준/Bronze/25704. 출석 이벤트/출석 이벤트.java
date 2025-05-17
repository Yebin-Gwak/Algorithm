import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int cost = Integer.parseInt(br.readLine());
		int ans = cost;
		
		if(c >= 20)
			ans = Math.min(cost * 3 / 4, cost - 2000);
		else if(c >= 15)
			ans = Math.min(cost - 2000, cost * 9 / 10);
		else if(c >= 10)
			ans = Math.min(cost * 9 / 10, cost - 500);
		else if(c >= 5)
			ans = cost - 500;
		
		ans = Math.max(ans, 0);
		System.out.println(ans);
	}

}