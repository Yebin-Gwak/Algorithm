import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int N;
		long[] tree;
		int MOD = 1000000007;
		
		SegTree(long[] arr){
			N = arr.length;
			tree = new long[N * 4];
			init(1, 1, N, arr);
		}
		
		void init(int idx, int start, int end, long[] arr) {
			if(start == end) {
				tree[idx] = arr[start - 1];
				return;
			}
			
			int mid = (start + end) / 2;
			init(idx * 2, start, mid, arr);
			init(idx * 2 + 1, mid + 1, end, arr);
			tree[idx] = (tree[idx * 2] % MOD) * (tree[idx * 2 + 1] % MOD) % MOD;
		}
		
		void update(int idx, int start, int end, int target, long v) {
			if(start == end) {
				tree[idx] = v;
				return;
			}
			
			int mid = (start + end) / 2;
			if(target <= mid)
				update(idx * 2, start, mid, target, v);
			else
				update(idx * 2 + 1, mid + 1, end, target, v);
			tree[idx] = (tree[idx * 2] % MOD) * (tree[idx * 2 + 1] % MOD) % MOD;
		}
		
		// left start end right
		long query(int idx, int start, int end, int left, int right) {
			if(start > right || end < left)
				return 1;
			if(left <= start && end <= right)
				return tree[idx];
			int mid = (start + end) / 2;
			return (query(idx * 2, start, mid, left, right) % MOD)
					* (query(idx * 2 + 1, mid + 1, end, left, right) % MOD)
							% MOD;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		for(int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());
		
		SegTree segTree = new SegTree(arr);
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine()); 
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(c == 1)
				segTree.update(1, 1, N, a, b);
			else
				sb.append(segTree.query(1, 1, N, Math.min(a, b), Math.max(a, b))).append("\n");
		}
		System.out.print(sb);
		
	}
}