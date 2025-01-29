import java.io.*;
import java.util.*;

public class Baekjoon1037 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int max = -987654321, min = 987654321;

        for(String c : s) {
            int temp = Integer.parseInt(c);
            if(max < temp) max = temp;
            if(min > temp) min = temp;
        }

        System.out.println(max * min);
    }
}
