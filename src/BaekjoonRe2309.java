import java.util.*;
import java.io.*;
public class BaekjoonRe2309 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[9];
        List<Integer> li = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int n = Integer.parseInt(br.readLine());
            li.add(n);
            sum += n;
        }
        Collections.sort(li);
        int i = 0;
        for(int n : li){
            nums[i++] = n;
        }
        int a = -1;
        int b = -1;
        for(int j = 0; j < 9; j++){
            for(int k = 0; k < 9; k++){
                if(sum - (nums[j] + nums[k]) == 100){
                    a = j;
                    b = k;
                }
            }
        }
        for(int j = 0; j < 9; j++){
            if(j == a || j == b)
                continue;
            System.out.println(nums[j]);
        }
    }
}
