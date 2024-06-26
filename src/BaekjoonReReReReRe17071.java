import java.util.*;
import java.io.*;
public class BaekjoonReReReReRe17071 {
    static int s, e;
    static int[][] visited;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visited = new int[500004][2];
        if(s == e){
            System.out.println(0);
            return;
        }
        q.add(s);
        visited[s][0] = 1;
        int turn = 0;
        int ok = 1;
        while(!q.isEmpty()){
            int size = q.size();
            turn++;
            e += turn;
            for(int j = 0; j < size; j++){
                int now = q.poll();
                if(e > 500000) {
                    ok = 0;
                    break;
                }
                if(visited[e][turn % 2] == 1){
                    System.out.println(turn);
                    return;
                }
                for(int i = 0; i < 3; i++){
                    int next = now;
                    if(i == 0) next += 1;
                    else if(i == 1) next -= 1;
                    else next *= 2;
                    if(next == e){
                        System.out.println(turn);
                        return;
                    }
                    if(next < 0|| next > 500000 || visited[next][turn % 2] == 1) continue;
                    q.add(next);
                    visited[next][turn % 2] = 1;
                }
            }
            if(ok == 0) break;
        }
        System.out.println(-1);
    }
}