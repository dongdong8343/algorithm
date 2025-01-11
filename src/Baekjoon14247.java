import java.io.*;
import java.util.*;
public class Baekjoon14247 {
    static class Tree{
        int idx;
        long after;
        public Tree(int idx, long after){
            this.idx = idx;
            this.after = after;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] a = new long[100004];
        ArrayList<Tree> li = new ArrayList<>();
        long ret = 0;

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) li.add(new Tree(i, (Long.parseLong(st.nextToken()))));

        Collections.sort(li, (o1, o2) -> {
            return (int)o1.after - (int)o2.after;
        });

        for(int i = 0; i < n; i++){
            ret += a[li.get(0).idx] + li.get(0).after * i;
            li.remove(0);
        }

        System.out.println(ret);
    }
}