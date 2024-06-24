import java.util.*;
import java.io.*;
public class BaekjoonReReReRe17071 {
    static int s, e, cnt = 0;
    static Queue<Integer> q = new LinkedList<>();
    static int[][] visited = new int[2][500004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e) {
            System.out.println(0);
            return;
        }
        q.add(s);
        visited[0][s] = 1;
        while(!q.isEmpty()){
            cnt++;
            e += cnt;
            if(e > 500000) break;
            if(visited[cnt % 2][e] == 1){
                System.out.println(cnt);
                return;
            }
            int n = q.size();
            for(int j = 0; j < n; j++){
                int now = q.poll();
                for(int i = 0; i < 3; i++){
                    int next = now;
                    if(i == 0) next += 1;
                    else if(i == 1) next -= 1;
                    else next *= 2;
                    if(next == e){
                        System.out.println(cnt);
                        return;
                    }
                    if(next < 0 || next > 500000) continue;
                    if(visited[cnt % 2][next] == 0){
                        visited[cnt % 2][next] = 1;
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(-1);
    }
}