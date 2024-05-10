import java.util.*;
import java.io.*;
public class BaekjoonRe17071 {
    static int s, e, ok = 0, turn = 1;
    static int[][] visited = new int[2][500004];
    static int[] op = {-1, 1, 2};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e){
            System.out.println(0);
            return;
        }
        visited[0][s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            e += turn;
            if(e > 500000) break;
            if(visited[turn % 2][e] != 0){
                ok = 1;
                break;
            }
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int now = q.poll();
                for(int j = 0; j < 3; j++){
                    int next = now;
                    if(op[j] == -1) next -= 1;
                    else if(op[j] == 1) next += 1;
                    else next *= 2;
                    if(next < 0 || next > 500000) continue;
                    if(next == e){
                        ok = 1;
                        break;
                    }
                    if(visited[turn % 2][next] == 0){
                        visited[turn % 2][next] = visited[turn % 2][now] + 1;
                        q.add(next);
                    }
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