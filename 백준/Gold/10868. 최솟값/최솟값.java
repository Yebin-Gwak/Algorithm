import java.util.*;
import java.io.*;

public class Main {
	
	static class SegTree{
		int N;
		int[] min;
		
		public SegTree(int[] arr) {
			N = arr.length;
			min = new int[N * 4];
			init(1, 1, N, arr);
		}
		
		void init(int idx, int start, int end, int[] arr) {
			if(start == end) {
				min[idx] = arr[start - 1];
				return;
			}
			int mid = (start + end) / 2;
			init(idx * 2, start, mid, arr);
			init(idx * 2 + 1, mid + 1, end, arr);
			min[idx] = Math.min(min[idx * 2], min[idx * 2 + 1]);
		}
		
		public int query(int idx, int start, int end, int left, int right) {
			if(end < left || start > right)
				return Integer.MAX_VALUE;
			if(left <= start && end <= right)
				return min[idx];
			int mid = (start + end) / 2;
			return Math.min(query(idx * 2, start, mid, left, right),
					query(idx * 2 + 1, mid + 1, end, left, right));
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		SegTree segTree = new SegTree(arr);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(segTree.query(1, 1, segTree.N, Math.min(a, b), Math.max(a, b)) + "\n");
		}

		System.out.print(sb);
		
	}
}
