import java.util.*;
import java.io.*;
public class Baekjoon2979 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a, b, c;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int arr[] = new int[104];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j = s; j < e; j++){
                arr[j]++;
            }
        }

        int sum = 0;

        for(int i = 0; i < 100; i++){
            if(arr[i] != 0){
                if(arr[i] == 1) sum += a;
                else if(arr[i] == 2) sum += b * 2;
                else if(arr[i] == 3) sum += c * 3;
            }
        }


        System.out.println(sum);
    }
}
