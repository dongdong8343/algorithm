import java.util.*;
import java.io.*;
public class Baekjoon1152 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0; boolean word = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') word = false;
            else if(!word){
                word = true;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}