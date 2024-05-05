import java.util.*;
import java.io.*;
public class Baekjoon12851{
    static int s, e;
    static int[] cnt = new int[100004];
    static int[] visited = new int[100004];
    static int[] op = {-1, 1, 2};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        cnt[s] = 1;
        visited[s] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == e) continue;
            for(int i = 0; i < 3; i++){
                int next = now;
                if(op[i] == -1) next -= 1;
                else if(op[i] == 1) next += 1;
                else next *= 2;
                if(next < 0 || next > 100000) continue;
                if(visited[next] == 0){
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    q.add(next);
                }else if(visited[next] == visited[now] + 1) cnt[next] += cnt[now];
            }
        }
        System.out.println(visited[e] - 1);
        System.out.println(cnt[e]);
    }
}