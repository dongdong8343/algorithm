import java.util.*;
import java.io.*;
public class Baekjoon17071 {
    static int s, e;
    static int[][] visited = new int[2][500004];
    static int[] op = {-1, 1, 0};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e){
            System.out.println(0);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[0][s] = 1;
        int turn = 1, ok = 0;
        while(!q.isEmpty()){
            e += turn;
            if(e > 500000) break;
            if(visited[turn % 2][e] == 1){
                ok = 1;
                break;
            }
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int n = q.poll();
                for(int j = 0; j < 3; j++){
                    int next = n;
                    if(op[j] == -1) next -= 1;
                    else if(op[j] == 1) next += 1;
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
            turn++;
        }
        if(ok == 1) System.out.println(turn);
        else System.out.println(-1);
    }
}