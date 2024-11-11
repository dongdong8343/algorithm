import java.util.*;
import java.io.*;

public class Inflearn2_1 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[104];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0 || arr[i] > arr[i - 1]) System.out.print(arr[i] + " ");
        }

        return;
    }
}