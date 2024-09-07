import java.util.*;

public class Baekjoon1280 {
    static final int max_n = 200004;
    static final long mod = (long) 1e9 + 7;
    static int n, value;
    static long ret = 1;
    static long[] tree_cnt = new long[max_n];
    static long[] tree_sum = new long[max_n];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            value = sc.nextInt() + 1;
            if (i != 1) {
                long left = value * sum(tree_cnt, 1, value - 1) - sum(tree_sum, 1, value - 1);
                long right = sum(tree_sum, value + 1, max_n - 1) - value * sum(tree_cnt, value + 1, max_n - 1);
                ret = (ret * ((left + right) % mod)) % mod;
            }
            update(tree_cnt, value, 1);
            update(tree_sum, value, value);
        }
        System.out.println(ret);
    }

    // Fenwick Tree에서 구간 합을 구하는 함수
    static long _sum(long[] tree, int value) {
        long _ret = 0;
        int i = value;
        while (i > 0) {
            _ret += tree[i];
            i -= (i & -i);
        }
        return _ret;
    }

    // 구간 [s, e]에 대한 합을 구하는 함수
    static long sum(long[] tree, int s, int e) {
        if (s > e) return 0;
        return (_sum(tree, e) - _sum(tree, s - 1));
    }

    // Fenwick Tree 업데이트 함수
    static void update(long[] tree, int x, long value) {
        int i = x;
        while (i < max_n) {
            tree[i] += value;
            i += (i & -i);
        }
    }
}
