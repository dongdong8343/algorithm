import java.util.*;
import java.io.*;
public class Baekjoon1213{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int[] cnt = new int[26];
        int flag = 0;
        String mid ="";
        StringBuilder ret = new StringBuilder();
        for(char a : word.toCharArray()) cnt[a-'A']++;
        for(int i = 'Z'; i >= 'A'; i--){
            if(cnt[i - 'A'] == 0) continue;
            if(cnt[i - 'A'] % 2 != 0){
                flag++;
                mid = String.valueOf((char)i);
                cnt[i - 'A']--;
            }
            if(flag == 2) break;
            for(int j = cnt[i - 'A']; j > 0; j -= 2){
                ret.append((char) (i));
                ret.insert(0, (char) (i));
            }
        }
        if(flag == 2) System.out.println("I'm Sorry Hansoo");
        else{
            if(!mid.isEmpty()){
                int index = ret.length() / 2;
                ret.insert(index, mid);
            }
            System.out.println(ret);
        }
    }
}