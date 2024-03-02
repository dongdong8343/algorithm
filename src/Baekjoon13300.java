import java.util.*;
import java.io.*;
public class Baekjoon13300 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][7];
        int cnt = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int temp1 = sc.nextInt();
            int temp2 = sc.nextInt();
            arr[temp1][temp2]++;
        }
        for(int i = 0; i < 2; i++){
            for(int j = 1; j < 7; j++){
                cnt += arr[i][j] / k;
                if(arr[i][j] % k != 0){
                    cnt++;
               }
            }
        }
        System.out.println(cnt);
    }
}
