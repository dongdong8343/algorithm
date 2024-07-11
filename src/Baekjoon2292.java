import java.util.*;
import java.io.*;
public class Baekjoon2292 {
    static int time = 1, n;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int sum = 1;
        if(n == 1) {
            System.out.println(time);
            return;
        }
        int idx = 1;
        while(true){
            time++;
            sum += (6 * idx++);
            if(sum >= n) {
                System.out.println(time);
                return;
            }
        }
    }
}