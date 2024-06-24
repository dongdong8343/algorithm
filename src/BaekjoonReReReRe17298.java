import java.util.*;
import java.io.*;

public class BaekjoonReReReRe17298 {
    static int n;
    static int[] arr;
    static int[] ret;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ret = new int[n];
        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                int t = s.pop();
                ret[t] = arr[i];
            }
            s.push(i);
        }
        while(!s.isEmpty()) ret[s.pop()] = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(ret[i]).append(' ');
        System.out.println(sb.toString());
    }
}