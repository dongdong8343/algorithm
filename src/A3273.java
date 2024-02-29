import java.util.*;
import java.io.*;
public class A3273 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i =0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int x = sc.nextInt();

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == x) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
