import java.util.*;
import java.io.*;
public class BaekjoonReReReRe12869 {
    static int n;
    static int[] hp = new int[3];
    static int[][][] map = new int[64][64][64];
    static Queue<Hp> q = new LinkedList<>();
    static int[][] att = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };
    static class Hp{
        public int a;
        public int b;
        public int c;
        Hp(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static void go(){
        while(!q.isEmpty()){
            Hp h = q.poll();
            for(int i = 0; i < 6; i++){
                int na = Math.max(0, h.a - att[i][0]);
                int nb = Math.max(0, h.b - att[i][1]);
                int nc = Math.max(0, h.c - att[i][2]);
                if(map[na][nb][nc] != 0) continue;
                map[na][nb][nc] = map[h.a][h.b][h.c] + 1;
                q.add(new Hp(na, nb, nc));
                if(na == 0 && nb == 0 && nc == 0) return;
            }
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) hp[i] = Integer.parseInt(st.nextToken());
        q.add(new Hp(hp[0], hp[1], hp[2]));
        go();
        System.out.println(map[0][0][0]);
    }
}