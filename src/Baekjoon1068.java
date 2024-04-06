import java.util.*;
import java.io.*;
public class Baekjoon1068 {
    static List<Integer>[] tree;
    static int num;
    static int dfs(int n){
        int cnt = 0, ret = 0;
        for(int x : tree[n]){
            if(x == num)
                continue;
            if(x > -1)
                cnt++;
            ret += dfs(x);
        }
        if(cnt == 0)
            return 1;
        return ret;
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new List[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        int root = 0;
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == -1){
                root = i;
                continue;
            }
            tree[x].add(i);
        }
        num = Integer.parseInt(br.readLine());
        if(num == root){
            System.out.println(0);
            return;
        }
        System.out.println(dfs(root));
    }
}