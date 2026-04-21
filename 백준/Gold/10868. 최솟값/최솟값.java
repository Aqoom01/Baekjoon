import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
    	int N = readInt();
    	int M = readInt();
    	
    	int[] value = new int[N];
    	for(int i = 0; i < N; i++) value[i] = readInt();
    	
    	SegmentTree tree = new SegmentTree(N);
    	tree.init(value, 1, 0, N - 1);
    	
    	for(int i = 0; i < M; i++) {
    		System.out.println(tree.findMin(readInt(), readInt()));
    	}
    }

    static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);
        int n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class SegmentTree {
	int tree[];
	int treeSize;
	int n;
	
	SegmentTree(int arrSize) {
		this.n = arrSize;
		int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
		
		this.treeSize = (int) Math.pow(2, h + 1);
		tree = new int[treeSize];
	}
	
	public int init(int[] arr, int node, int start, int end) {
		if(start == end) return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		int leftMin = init(arr, node * 2, start, mid);
		int rightMin = init(arr, node * 2 + 1, mid + 1, end);
		
		return tree[node] = Math.min(leftMin, rightMin);
	}
	
	public int findMin(int a, int b) {
		return findMin(1, 0, n - 1, a - 1, b - 1);
	}
	
	public int findMin(int node, int start, int end, int left, int right) {
		if(right < start || end < left) return Integer.MAX_VALUE;
		if(left <= start && end <= right) return tree[node];
		
		int mid = (start + end) / 2;
		int leftMin = findMin(node * 2, start, mid, left, right);
		int rightMin = findMin(node * 2 + 1, mid + 1, end, left, right);
		return Math.min(leftMin, rightMin);
	}
}