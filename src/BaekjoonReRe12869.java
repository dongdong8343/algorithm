import java.util.*;
import java.io.*;
public class BaekjoonReRe12869 {
    static class Hp{
        public int a;
        public int b;
        public int c;
        public Hp(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int[][][] visited = new int[64][64][64];
    static int[][] att = {
            {9,1,3},
            {9,3,1},
            {3,1,9},
            {3,9,1},
            {1,3,9},
            {1,9,3},
    };
    static int n;
    static int arr[] = new int[3];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Hp hp = new Hp(arr[0], arr[1], arr[2]);
        Queue<Hp> q = new LinkedList<>();
        q.add(hp);
        int ok = 0;
        visited[arr[0]][arr[1]][arr[2]] = 1;
        while(!q.isEmpty()){
            Hp temp = q.poll();
            for(int i = 0; i < 6; i++){
                int ta = temp.a;
                int tb = temp.b;
                int tc = temp.c;
                ta = Math.max(0, ta - att[i][0]);
                tb = Math.max(0, tb - att[i][1]);
                tc = Math.max(0, tc - att[i][2]);
                if(visited[ta][tb][tc] == 0){
                    visited[ta][tb][tc] = visited[temp.a][temp.b][temp.c] + 1;
                    if(ta == 0 && tb == 0 && tc == 0) {
                        ok = 1;
                        break;
                    }
                    q.add(new Hp(ta, tb, tc));
                }
            }
            if(ok == 1) break;
        }
        System.out.println(visited[0][0][0] - 1);
    }
}