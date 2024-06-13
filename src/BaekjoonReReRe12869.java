import java.util.*;
import java.io.*;
public class BaekjoonReReRe12869 {
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
    static int n;
    static int[][][] visited = new int[64][64][64];
    static int[][] att = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 3, 9},
            {1, 9, 3}
    };
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[3];
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Hp hp = new Hp(arr[0], arr[1], arr[2]);
        visited[hp.a][hp.b][hp.c] = 1;
        Queue<Hp> q = new LinkedList<>();
        q.add(hp);
        while(!q.isEmpty()){
            Hp temp = q.poll();
            for(int i = 0; i < 6; i++){
                int a = Math.max(0, temp.a - att[i][0]);
                int b = Math.max(0, temp.b - att[i][1]);
                int c = Math.max(0, temp.c - att[i][2]);
                if(visited[a][b][c] != 0) continue;
                visited[a][b][c] = visited[temp.a][temp.b][temp.c] + 1;
                if(a == 0 && b == 0 && c == 0){
                    System.out.println(visited[a][b][c] - 1);
                    return;
                }
                q.add(new Hp(a, b, c));
            }
        }
    }
}
