import java.util.*;
import java.io.*;
public class BaekjoonReReRe1068 {
    static List<Integer>[] tree;
    static int n, del;
    static int dfs(int root){
        int ret = 0, cnt = 0;
        for(int i : tree[root]){
            if(i == del)
                continue;
            cnt++;
            ret += dfs(i);
        }
        if(cnt == 0)
            return 1;
        return ret;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new List[n];
        for(int i = 0; i < n; i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < n; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == -1){
                root = i;
                continue;
            }
            tree[x].add(i);
        }
        del = Integer.parseInt(br.readLine());
        if(del == root){
            System.out.println(0);
            return;
        }
        System.out.println(dfs(root));
    }
}
