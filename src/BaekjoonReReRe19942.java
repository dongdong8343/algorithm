import java.util.*;
import java.io.*;
public class BaekjoonReReRe19942 {
    static int n, mp, mf, ms, mv, min = 987654321;
    static List<Info> all = new ArrayList<>();
    static List<Integer> ret = new ArrayList<>();
    public static class Info{
        public int p;
        public int f;
        public int s;
        public int v;
        public int c;
        Info(int p, int f, int s, int v, int c){
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }
    static void go(){
        for(int i = 1; i < (1 << n); i++){
            int sp = 0, sf = 0, ss = 0, sv = 0, sc = 0;
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    sp += all.get(j).p;
                    sf += all.get(j).f;
                    ss += all.get(j).s;
                    sv += all.get(j).v;
                    sc += all.get(j).c;
                    temp.add(j + 1);
                }
            }
            if(sp >= mp && sf >= mf && ss >= ms && sv >= mv){
                if(min < sc) continue;
                if(min > sc){
                    min = sc;
                    ret = temp;
                }
                else{
                    if(check(temp, ret) < 0) ret = temp;
                }
            }
        }
    }
    static int check(List<Integer> li1, List<Integer> li2){
        int size = Math.min(li1.size(), li2.size());
        for(int i = 0; i < size; i++){
            if(!li1.get(i).equals(li2.get(i))) return li1.get(i) - li2.get(i);
        }
        return li1.size() - li2.size();
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for(int j = 0; j < 5; j++) arr[j] = Integer.parseInt(st.nextToken());
            all.add(new Info(arr[0], arr[1], arr[2], arr[3], arr[4]));
        }
        go();
        if(min == 987654321) System.out.println(-1);
        else{
            System.out.println(min);
            for(int i : ret) System.out.print(i + " ");
        }
    }
}