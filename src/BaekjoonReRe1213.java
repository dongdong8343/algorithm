import java.io.*;
import java.util.*;
public class BaekjoonReRe1213 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] arr = new int[26];
        for(char c : word.toCharArray()){
            int n = c - 'A';
            arr[n]++;
        }
        char mid = ' ';
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(char i = 'Z'; i >= 'A'; i--){
            int n = i - 'A';
            if(arr[n] % 2 != 0){
                mid = i;
                arr[n]--;
                cnt++;
            }
            if(cnt >= 2)
                break;
            for(int j = arr[n]; j > 0; j -= 2){
                sb.append(i);
                sb.insert(0, i);
            }
        }
        if(cnt >= 2)
            System.out.println("I'm Sorry Hansoo");
        else if(cnt == 1){
            int n = sb.toString().length() / 2;
            sb.insert(n, mid);
            System.out.println(sb);
        }
        else{
            System.out.println(sb);
        }
    }
}
