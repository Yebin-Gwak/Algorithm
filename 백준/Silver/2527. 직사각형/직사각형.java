import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 4; i++) {
			int ax, ay, ap, aq, bx, by, bp, bq;
			st = new StringTokenizer(br.readLine());
			ax = Integer.parseInt(st.nextToken());
			ay = Integer.parseInt(st.nextToken());
			ap = Integer.parseInt(st.nextToken());
			aq = Integer.parseInt(st.nextToken());
			bx = Integer.parseInt(st.nextToken());
			by = Integer.parseInt(st.nextToken());
			bp = Integer.parseInt(st.nextToken());
			bq = Integer.parseInt(st.nextToken());
			
			if (bx > ap || by > aq || bp < ax || bq < ay) {
				System.out.println("d");
			} else if ((ax == bp && aq == by) || (ax == bp && ay == bq) || (ap == bx && ay == bq) || (ap == bx && aq == by)) {
				System.out.println("c");
			} else if (ap == bx || aq == by || bp == ax || ay == bq) {
				System.out.println("b");
			} else {
				System.out.println("a");
			}
			

		}
		

	}

}