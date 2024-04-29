import java.util.*;
import java.io.*;
public class BaekjoonReReReRe1068 {
    static int n, del;
    static List<Integer>[] tree;
    static int dfs(int s){
        int flag = 0, ret = 0;
        for(int node : tree[s]){
            if(node == del)
                continue;
            flag = 1;
            ret += dfs(node);
        }
        if(flag == 0)
            return 1;
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = 0;
        n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for(int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1){
                root = i;
                continue;
            }
            tree[temp].add(i);
        }
        del = Integer.parseInt(br.readLine());
        if(del == root){
            System.out.println(0);
            return;
        }
        System.out.println(dfs(root));
    }
}