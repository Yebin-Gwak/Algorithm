import java.io.*;
import java.util.*;

public class Main {
	
	static class SegTree{
		long[] tree;
		long[] lazy;
		int N;
		
		SegTree(long[] arr){
			N = arr.length;
			tree = new long[N * 4];
			lazy = new long[N * 4];
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
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		}
		
		void update(int left, int right, long v) {
			update(1, 1, N, left, right, v);
		}
		
		void update(int idx, int start, int end, int left, int right, long v) {
			if(lazy[idx] != 0)
				propagate(idx, start, end);
			if(start > right || end < left)
				return;
			if(left <= start && end <= right) {
				lazy[idx] = v;
				propagate(idx, start, end);
				return;
			}
			int mid = (start + end) / 2;
			update(idx * 2, start, mid, left, right, v);
			update(idx * 2 + 1, mid + 1, end, left, right, v);
			tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		}
		
		void propagate(int idx, int start, int end) {
			if(start != end) {
				lazy[idx * 2] += lazy[idx];
				lazy[idx * 2 + 1] += lazy[idx];
			}
			tree[idx] += lazy[idx] * (end - start + 1);
			lazy[idx] = 0;
		}
		
		long query(int left, int right) {
			long result = query(1, 1, N, left, right);
			return result;
		}
		
		long query(int idx, int start, int end, int left, int right) {
			if(lazy[idx] != 0)
				propagate(idx, start, end);
			if(start > right || end < left)
				return 0;
			if(left <= start && end <= right)
				return tree[idx];
			int mid = (start + end) / 2;
			return query(idx * 2, start, mid, left, right)
					+query(idx * 2 + 1, mid + 1, end, left, right);
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		for(int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());
		
		SegTree segTree = new SegTree(arr);
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(cmd == 1)
				segTree.update(a, b, Long.parseLong(st.nextToken()));
			else
				sb.append(segTree.query(a, b)).append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}
