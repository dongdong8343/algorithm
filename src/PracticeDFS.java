import java.util.*;
import java.io.*;
public class PracticeDFS {
    static ArrayList<Integer>[] adj;
    static int[] visited = new int[10];
    static void dfs(int u){
        visited[u] = 1;
        System.out.println(u);
        for(int i : adj[u]){
            if(visited[i] == 0)
                dfs(i);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        adj = new ArrayList[10];
        for(int i = 0; i < 10; i++){
            adj[i] = new ArrayList<>();
        }
        adj[1].add(2);
        adj[1].add(3);
        adj[2].add(4);
        adj[4].add(2);
        adj[2].add(5);
        dfs(1);

    }
}
