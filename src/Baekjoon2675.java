import java.util.*;
import java.io.*;
public class Baekjoon2675 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i = 0; i < s.length(); i++){
                for(int j = 0; j < a; j++){
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }
    }
}