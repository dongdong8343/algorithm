import java.util.*;
import java.io.*;
public class BaekjoonReReReReRe12851 {
    static int s, e;
    static int[] visited = new int[100004];
    static int[] cnt = new int[100004];
    static Queue<Integer> q = new LinkedList<>();
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
        q.add(s);
        visited[s] = 1;
        cnt[s] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < 3; i++){
                int next = now;
                if(i == 0) next++;
                else if(i == 1) next--;
                else next *= 2;
                if(next < 0 || next > 100000) continue;
                if(visited[next] == 0){
                    visited[next] = visited[now] + 1;
                    cnt[next] += cnt[now];
                    q.add(next);
                } else if(visited[next] == visited[now] + 1){
                    cnt[next] += cnt[now];
                }
            }
        }
        System.out.println(visited[e] - 1);
        System.out.println(cnt[e]);

    }
}