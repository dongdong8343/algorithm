import java.util.*;
import java.io.*;
public class Baekjoon13244 {
    static int tc, n, e, mask;
    static int[] arr = new int[1004];
    static ArrayList<Integer>[] li;
    static void go(int t){
        arr[t] = 1;
        for(int i : li[t]){
            if(arr[i] == 0) go(i);
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for(int s = 0; s < tc; s++){
            n = Integer.parseInt(br.readLine());
            e = Integer.parseInt(br.readLine());
            arr = new int[1004];
            li = new ArrayList[n + 1];
            for(int i = 0; i <= n; i++)
                li[i] = new ArrayList<>();
            for(int i = 0; i < e; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                li[a].add(b);
                li[b].add(a);
            }
            if(e != n - 1){
                System.out.println("graph");
                continue;
            }
            go(1);
            int no = 0;
            for(int j = 1; j <= n; j++){
                if(arr[j] == 0) {
                    no = 1;
                    break;
                }
            }
            if(no == 0) System.out.println("tree");
            else System.out.println("graph");
        }
    }
}