import java.io.*;
import java.util.*;

public class Main {
	
	static class Matter{
		int[][][] nums = new int[4][4][4];
		int[][][] colors = new int[4][4][4];
		
		public Matter(int[][] num, int[][] color) {
			this.nums[0] = num;
			this.colors[0] = color;
			
			for(int i = 1; i < 4; i++) {
				nums[i] = rotate90(nums[i - 1]);
				colors[i] = rotate90(colors[i - 1]);
			}
		}
		
	    private int[][] rotate90(int[][] src) {
	        int[][] arr = new int[4][4];
	        for (int r = 0; r < 4; r++)
	            for (int c = 0; c < 4; c++)
	                arr[c][4 - 1 - r] = src[r][c];
	        return arr;
	    }
		
	}

	static HashMap<Character, Integer> elemental = new HashMap<>();
	
	static int N;
	static Matter[] matters;
	static int[] dx = new int[] {0, 0, 1, 1};
	static int[] dy = new int[] {0, 1, 0, 1};
	static HashSet<Integer> combs = new HashSet<>();
	static int[] pick = new int[3];
	static boolean[] visited;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		matters = new Matter[N];
		visited = new boolean[N];
		
		elemental.put('R', 7); 
		elemental.put('B', 5); 
		elemental.put('G', 3); 
		elemental.put('Y', 2); 
		elemental.put('W', 0);
		
		getComb(0);
		
		for(int i = 0; i < N; i++) {
			int[][] num = new int[4][4];
			int[][] color = new int[4][4];
			
			for(int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 4; k++)
					num[j][k] = Integer.parseInt(st.nextToken());
			}
			
			for(int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 4; k++)
					color[j][k] = elemental.get(st.nextToken().charAt(0));
			}
			
			matters[i] = new Matter(num, color);
		}
		
		for(int comb : combs) {
			for(int a = 0; a < 4; a++) 
				for(int b = 0; b < 4; b++) 
					for(int c = 0; c < 4; c++) 
						play(comb, a, b, c);
		}
		
		System.out.println(ans);
		
	}
	
	private static void play(int comb, int r1, int r2, int r3) {
		Matter m1 = (comb < 100) ? matters[0] : matters[comb / 100];
		Matter m2 = matters[comb % 100 / 10];
		Matter m3 = matters[comb % 10];
		
		int[][][] nums = new int[3][4][4];
		nums[0] = m1.nums[r1];
		nums[1] = m2.nums[r2];
		nums[2] = m3.nums[r3];
		
		int[][][] colors = new int[3][4][4];
		colors[0] = m1.colors[r1];
		colors[1] = m2.colors[r2];
		colors[2] = m3.colors[r3];
		
		for(int a = 0; a < 4; a++) 
			for(int b = 0; b < 4; b++) 
				for(int c = 0; c < 4; c++)
					mix(nums, colors, new int[] {a, b, c});
		
	}

	private static void mix(int[][][] nums, int[][][] colors, int[] d) {
		int[][] value = new int[5][5];
		int[][] elemental = new int[5][5];
		
		for(int i = 0; i < 3; i++) {
			int x = dx[d[i]];
			int y = dy[d[i]];
			
			for(int j = x; j < x + 4; j++) {
				for(int k = y; k < y + 4; k++) {
					value[j][k] += nums[i][j - x][k - y];
					if(value[j][k] < 0)
						value[j][k] = 0;
					else if(value[j][k] > 9)
						value[j][k] = 9;
					
					if(colors[i][j - x][k - y] == 0)
						continue;
					elemental[j][k] = colors[i][j - x][k - y];
				}
			}
			
		}
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				sum += value[i][j] * elemental[i][j];
			}
		}
		
		ans = Math.max(ans, sum);
		
	}

	private static void getComb(int now) {
		if(now == 3) {
			int result = 0;
			for(int n : pick)
				result = (result * 10) + n;
			combs.add(result);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			pick[now] = i;
			getComb(now + 1);
			visited[i] = false;
		}
		
	}

}
