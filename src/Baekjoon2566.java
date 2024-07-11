import java.io.*;
import java.util.*;
public class Baekjoon2566 {
    static int max = -1, y, x;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1; i <= 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++){
                int a = Integer.parseInt(st.nextToken());
                if(max < a){
                    max = a;
                    y = i;
                    x = j;
                }
            }
        }
        System.out.println(max);
        System.out.println(y + " " + x);

    }
}