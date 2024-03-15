import java.util.*;
import java.io.*;
public class Baekjoon1159 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int members = Integer.parseInt(br.readLine());
        String [] names = new String[members];
        int[] al = new int[26];

        for(int i = 0; i < members; i++){
            names[i] = br.readLine();
        }

        for(int i = 0; i < members; i++){
            int index = names[i].charAt(0) - 'a';
            al[index]++;
        }

        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(al[i] >= 5){
                cnt++;
                int n = i + 'a';
                char a = (char) n;
                System.out.print(a);
            }
        }
        if(cnt == 0) System.out.println("PREDAJA");
    }
}
