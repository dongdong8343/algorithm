import java.util.*;
import java.io.*;
public class BaekjoonRe17298 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[n];
        int[] ret = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!s.empty() && arr[s.peek()] < arr[i]){
                ret[s.pop()] = arr[i];
            }
            s.push(i);
        }

        while(!s.empty()){
            ret[s.pop()] = -1;
        }

        for(int i : ret)
            System.out.print(i + " ");

    }
}
