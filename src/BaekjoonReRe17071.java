import java.util.*;
import java.io.*;
public class BaekjoonReRe17071 {
    static int turn = 0, s, e;
    static int[][] visited = new int[2][500004];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[0][s] = 1;
        if(s == e){
            System.out.println(0);
            return;
        }
        int ok = 0;
        while(true){
            turn++;
            e += turn;
            if(e > 500000) break;
            if(visited[turn % 2][e] == 1) {
                ok = 1;
                break;
            }
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int now = q.poll();
                for(int j = 0; j < 3; j++){
                    int next = now;
                    if(j == 0) next -= 1;
                    else if(j == 1) next += 1;
                    else next *= 2;
                    if(next < 0 || next > 500000 || visited[turn % 2][next] == 1) continue;
                    if(next == e){
                        ok = 1;
                        break;
                    }
                    visited[turn % 2][next] = 1;
                    q.add(next);
                }
                if(ok == 1) break;
            }
            if(ok == 1) break;
        }
        if(ok == 1) System.out.println(turn);
        else System.out.println(-1);
    }
}