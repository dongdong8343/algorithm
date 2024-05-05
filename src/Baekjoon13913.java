import java.util.*;
import java.io.*;
public class Baekjoon13913 {
    static int s, e;
    static int[] visited = new int[100004];
    static int[] road = new int[100004];
    static int[] op = {-1, 1, 0};
    static List<Integer> li= new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        if(s == e){
            System.out.println(0);
            System.out.println(e);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == e) break;
            for(int i = 0; i < 3; i++){
                int next = now;
                if(op[i] == -1) next -= 1;
                else if(op[i] == 1) next += 1;
                else next *= 2;
                if(next < 0 || next > 100000) continue;
                if(visited[next] == 0){
                    visited[next] = visited[now] + 1;
                    road[next] = now;
                    q.add(next);
                }
            }
        }
        q.clear();
        int a = -1;
        q.add(e);
        li.add(e);
        while(true){
            a = q.poll();
            li.add(road[a]);
            if(road[a] == s) break;
            q.add(road[a]);
        }
        System.out.println(visited[e] - 1);
        for(int i = li.size() - 1; i >= 0; i--){
            System.out.print(li.get(i) + " ");
        }
    }
}