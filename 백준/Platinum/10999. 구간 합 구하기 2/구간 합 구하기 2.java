import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = readInt();
        int M = readInt();
        int K = readInt();

        long[] value = new long[N];
        for (int i = 0; i < N; i++) value[i] = readLong();

        SegmentTree tree = new SegmentTree(N);
        tree.init(value, 1, 0, N - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            int option = readInt();

            if (option == 1) {
                int left = readInt() - 1;
                int right = readInt() - 1;
                long diff = readLong();

                tree.updateRange(1, 0, N - 1, left, right, diff);
            } else {
                int left = readInt() - 1;
                int right = readInt() - 1;

                sb.append(tree.sum(1, 0, N - 1, left, right)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int readInt() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);

        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }

        int n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n * sign;
    }

    static long readLong() throws IOException {
        int c;
        while ((c = System.in.read()) <= 32);

        long sign = 1;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }

        long n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = n * 10 + (c & 15);
        }
        return n * sign;
    }
}

class SegmentTree {
    long[] tree;
    long[] lazy;
    int treeSize;
    int n;

    SegmentTree(int arrSize) {
        this.n = arrSize;
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        this.treeSize = 1 << (h + 1);

        tree = new long[treeSize];
        lazy = new long[treeSize];
    }

    public long init(long[] arr, int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(arr, node * 2, start, mid)
                + init(arr, node * 2 + 1, mid + 1, end);
    }

    private void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1L) * lazy[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }

            lazy[node] = 0;
        }
    }

    public void updateRange(int node, int start, int end, int left, int right, long diff) {
        propagate(node, start, end);

        if (right < start || end < left) return;

        if (left <= start && end <= right) {
            lazy[node] += diff;
            propagate(node, start, end);
            return;
        }

        int mid = (start + end) / 2;
        updateRange(node * 2, start, mid, left, right, diff);
        updateRange(node * 2 + 1, mid + 1, end, left, right, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public long sum(int node, int start, int end, int left, int right) {
        propagate(node, start, end);

        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return sum(node * 2, start, mid, left, right)
                + sum(node * 2 + 1, mid + 1, end, left, right);
    }
}