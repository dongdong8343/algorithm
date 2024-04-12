import java.util.*;
import java.io.*;
public class BaekjoonReRe1068 {
    static List<Integer>[] li;
    static int del;
    static int dfs(int n){
        int ret = 0, cnt = 0;
        for(int x : li[n]){
            if(x == del)
                continue;
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
        li = new List[n];
        for(int i = 0; i < n; i++){
            li[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == -1){
                root = i;
                continue;
            }
            li[x].add(i);
        }
        del = Integer.parseInt(br.readLine());
        if(del == root){
            System.out.println(0);
            return;
        }
        System.out.println(dfs(root));
    }
}
