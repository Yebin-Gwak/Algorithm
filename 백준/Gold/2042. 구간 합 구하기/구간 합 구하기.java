import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		int n;
		long[] tree;
		int target;
		int left;
		int right;
		
		SegTree(long[] arr){
			n = arr.length;
			tree = new long[n * 4];
			init(1, 1, n, arr);
		}
		
		void init(int idx, int start, int end, long[] arr) {
			if(start == end) {
				tree[idx] = arr[start - 1];
				return;
			}
			
			int mid = (start + end) / 2;
			init(idx * 2, start, mid, arr);
			init(idx * 2 + 1, mid + 1, end, arr);
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		}
		
		void update(int target, long v) {
			this.target = target;
			update(1, 1, n, v);
		}
		
		void update(int idx, int start, int end, long v) {
			if(start == end) {
				tree[idx] = v;
				return;
			}
			
			int mid = (start + end) / 2;
			if(target <= mid)
				update(idx * 2, start, mid, v);
			else
				update(idx * 2 + 1, mid + 1, end, v);
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		}
		
		long query(int left, int right) {
			this.left = left;
			this.right = right;
			return get(1, 1, n);
		}
		
		long get(int idx, int start, int end) {
			if(right < start || left > end)
				return 0;
			if(left <= start && end <= right)
				return tree[idx];
			int mid = (start + end) / 2;
			return get(idx * 2, start, mid) + get(idx * 2 + 1, mid + 1, end);
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
			long b = Long.parseLong(st.nextToken());
			if(c == 1)
				segTree.update(a, b);
			else
				sb.append(segTree.query(a, (int) b)).append("\n");
		}
		
		System.out.print(sb);
		
	}
}