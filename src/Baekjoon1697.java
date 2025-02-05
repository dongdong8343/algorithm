import java.io.*;
import java.util.*;

public class Baekjoon1697 {
    static int s, e;
    static int[] d = {-1, 1, 2};
    static int[] a = new int[100004];

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int ret = bfs();

        System.out.println(ret);
    }

    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        a[s] = 1;

        while(!q.isEmpty()){
            int t = q.poll();
            if(t == e) return a[t] - 1;
            for(int i = 0; i < 3; i++){
                int next = t;

                if(d[i] == 2) next *= 2;
                else next += d[i];

                if(next < 0 || next > 100000) continue;

                if(a[next] == 0) {
                    a[next] = a[t] + 1;
                    q.add(next);
                }
            }
        }

        return -1;
    }
}