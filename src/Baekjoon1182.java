import java.io.*;
import java.util.*;
public class Baekjoon1182 {
    static int cnt = 0, sum, n;
    static int[] nums = new int[24];

    static void go(int s, int now){
        if(s == n) {
            if(now == sum) cnt++;
            return;
        }
        go(s + 1, now + nums[s]);
        go(s + 1, now);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        sum = Integer.parseInt(s[1]);

        String[] numbers = br.readLine().split(" ");
        nums = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }

        go(0, 0);
        if(sum == 0) cnt--;
        System.out.println(cnt);
    }
}