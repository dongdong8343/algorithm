import java.util.*;
import java.io.*;

public class Inflearn2_4 {
    static int n;
    static int[] arr = new int[60];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr[0] = 1; arr[1] = 1;

        for(int i = 0; i < n; i++){
            if(i == 0 || i == 1) System.out.print(1 + " ");
            else{
                arr[i] = arr[i - 1] + arr[i - 2];
                System.out.print(arr[i] + " ");
            }
        }


        return ;
    }
}
