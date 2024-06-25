import java.util.*;
import java.io.*;
public class BaekjoonReReReRe19942 {
    static class Info{
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
    static int n, mp, mf, ms, mv, ret = 987654321;
    static ArrayList<Integer> retLi = new ArrayList<>();
    static Info[] info;
    static void go(){
        for(int i = 1; i < (1 << n); i++){
            int sp = 0, sf = 0, ss = 0, sv = 0;
            int sc = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    sp += info[j + 1].p;
                    sf += info[j + 1].f;
                    ss += info[j + 1].s;
                    sv += info[j + 1].v;
                    sc += info[j + 1].c;
                    temp.add(j + 1);
                }
            }
            if(sp >= mp && sf >= mf && ss >= ms && sv >= mv){
                if(ret > sc){
                    ret = sc;
                    retLi = temp;
                }
                else if(ret == sc && sort(temp, retLi) < 0) retLi = temp;
            }
        }
    }
    static int sort(ArrayList<Integer> a, ArrayList<Integer> b){
        int asize = a.size();
        int bsize = b.size();
        int size = Math.min(asize, bsize);
        for(int i = 0; i < size; i++)
            if(!a.get(i).equals(b.get(i))) return a.get(i) - b.get(i);
        return asize - bsize;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        info = new Info[n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[5];
            for(int j = 0; j < 5; j++)
                temp[j] = Integer.parseInt(st.nextToken());
            info[i] = new Info(temp[0], temp[1], temp[2], temp[3], temp[4]);
        }
        go();
        if(ret != 987654321){
            System.out.println(ret);
            for(int i : retLi) System.out.print(i + " ");
        }
        else{
            System.out.println(-1);
        }
    }
}