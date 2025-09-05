import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] hsv = new int[3][2];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			hsv[i][0] = Integer.parseInt(st.nextToken());
			hsv[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int M = Math.max(R, Math.max(G, B));
		int m = Math.min(R, Math.min(G, B));
		double V = M;
		double S = 255.0 * (V - m) / V;
		double H = 0.0;
		if(V == R)
			H = (60 * (G - B)) / (V - m);
		else if(V == G)
			H = 120 + ((60 * (B - R)) / (V - m));
		else if(V == B)
			H = 240 + ((60 * (R - G)) / (V - m));
		if(H < 0)
			H += 360.0;
		if(hsv[0][0] <= H && H <= hsv[0][1] &&
				hsv[1][0] <= S && S <= hsv[1][1] &&
				hsv[2][0] <= V && V<= hsv[2][1])
			System.out.println("Lumi will like it.");
		else
			System.out.println("Lumi will not like it.");
	}
}