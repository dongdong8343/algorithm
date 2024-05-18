import java.util.*;
import java.io.*;
public class Baekjoon9934 {
    static int n;
    static List<Integer>[] li;
    static int[] num;
    static void solve(int idx, int left, int right){
        int mid = (left + right) / 2;
        li[idx].add(num[mid]);
        if(idx == n - 1) return;
        solve(idx + 1, left, mid - 1);
        solve(idx + 1, mid + 1, right);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += (int) Math.pow(2, i);
        }
        li = new List[n];
        num = new int[sum];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            li[i] = new ArrayList<>();
        }
        for(int i = 0; i < sum; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0, num.length - 1);
        for(int i = 0; i < n; i++){
            for(int a : li[i]) System.out.print(a + " ");
            System.out.println();
        }
    }
}