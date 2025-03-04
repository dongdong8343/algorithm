import java.io.*;
import java.util.*;

class ProgrammersNetwork {
    public static List<Integer>[] a;
    public static boolean[] v;

    public int solution(int n, int[][] computers) {
        int ret = 0;

        a = new List[n + 1];
        v = new boolean[n + 4];

        for(int i = 0; i < n; i++) {
            a[i] = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                if(i == j || computers[i][j] == 0) continue;
                a[i].add(j);
            }
        }

        for(int i = 0; i < n; i++) {
            if(!v[i]) {
                ret++;
                dfs(i);
            }
        }

        return ret;
    }

    public void dfs(int here) {
        v[here] = true;
        for(int x : a[here]) {
            if(!v[x]) dfs(x);
        }
    }
}