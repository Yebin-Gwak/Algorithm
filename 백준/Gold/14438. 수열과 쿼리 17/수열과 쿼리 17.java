import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int N;
		int[] min;
		
		public SegTree(int[] arr) {
			this.N = arr.length;
			min = new int[N * 4];
			Arrays.fill(min, Integer.MAX_VALUE);
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
		
		void update(int idx, int start, int end, int target, int v) {
			if(start == end) {
				min[idx] = v;
				return;
			}
			
			int mid = (start + end) / 2;
			if(target <= mid)
				update(idx * 2, start, mid, target, v);
			else
				update(idx * 2 + 1, mid + 1, end, target, v);
			min[idx] = Math.min(min[idx * 2], min[idx * 2 + 1]);
		}
		
		int query(int idx, int start, int end, int left, int right) {
			if(start > right || end < left)
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
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		SegTree segTree = new SegTree(arr);
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(c == 1)
				segTree.update(1, 1, N, a, b);
			else
				sb.append(segTree.query(1, 1, N, a, b)).append("\n");
		}
		System.out.print(sb);
	}
}
