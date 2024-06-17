import java.util.*;
import java.io.*;
public class BaekjoonReReRe17071 {
    static int s, e;
    static int[][] visited = new int[2][500004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e){
            System.out.println(0);
            return;
        }
        int turn = 0;
        visited[0][s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            turn++;
            e += turn;
            if(e > 500000) break;
            if(visited[turn % 2][e] == 1){
                System.out.println(turn);
                return;
            }
            int qsize = q.size();
            for(int i = 0; i < qsize; i++){
                int now = q.poll();
                for(int j = 0; j < 3; j++){
                    int next = now;
                    if(j == 0) next += 1;
                    else if(j == 1) next -= 1;
                    else next *= 2;
                    if(next < 0 || next > 500000) continue;
                    if(next == e){
                        System.out.println(turn);
                        return;
                    }
                    if(visited[turn % 2][next] == 0) {
                        visited[turn % 2][next] = 1;
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
