import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1325 {
    static List<Integer>[] li;
    static int[] visited;
    static int dfs(int n){
        visited[n] = 1;
        int ret = 1;
        for(int x : li[n]){
            if(visited[x] == 1)
                continue;
            ret += dfs(x);
        }
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        li = new List[n + 1];
        for(int i = 1; i <= n; i++){
            li[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li[b].add(a);
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            visited = new int[n + 1];
            int cnt = dfs(i);
            map.put(i, cnt);
            max = Math.max(max, cnt);
        }

        List<Integer> ret = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max)
                ret.add(key);
        }
        Collections.sort(ret);
        for(int i : ret)
            System.out.print(i + " ");
    }
}
