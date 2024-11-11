import java.util.*;
import java.io.*;

public class Inflearn2_3 {
    static int n;
    static int[] a = new int[100004];
    static int[] b = new int[100004];
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            b[i] = Integer.parseInt(st.nextToken());

        // 배열들 순회하면서 비기면 D, 아니면 결과 판단해서 결과 출력하기
        for(int i = 0; i < n; i++){
            if(a[i] == b[i]) System.out.println("D");
            else if(a[i] == 1){
                if(b[i] == 2) System.out.println("B");
                else System.out.println("A");
            }else if(a[i] == 2){
                if(b[i] == 1) System.out.println("A");
                else System.out.println("B");
            }else{
                if(b[i] == 1) System.out.println("B");
                else System.out.println("A");
            }
        }


        return ;
    }
}
