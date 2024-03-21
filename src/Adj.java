import java.util.*;
import java.io.*;
public class Adj {
    static int[] visited = new int[10];
    static ArrayList<Integer>[] adj;

    public static void go(int idx){
        System.out.println(idx);
        visited[idx] = 1;
        for(int there : adj[idx]){
            if(visited[there] == 1) continue;
            go(there);
        }
        return;
    }

    public static void main(String[] args)throws Exception{
        int n = 10;
        adj = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        adj[1].add(2);
        adj[2].add(1);

        adj[1].add(3);
        adj[3].add(1);

        adj[3].add(4);
        adj[4].add(3);

        for(int i = 0; i < n; i++){
            if(!adj[i].isEmpty() && visited[i] == 0) go(i);
        }
    }
}
