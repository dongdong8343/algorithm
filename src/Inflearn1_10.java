import java.util.*;
import java.io.*;

public class Inflearn1_10{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char c = st.nextToken().charAt(0);
        List<Integer> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == c) li.add(i);
        }

        for(int i = 0; i < s.length(); i++){
            if(c == s.charAt(i)) sb.append(0).append(' ');
            else{
                int min = 987654321;
                for(int t : li){
                    min = Math.min(min, Math.abs(i - t));
                }
                sb.append(min).append(' ');
            }
        }
        System.out.println(sb.toString());

        return ;
    }
}