import java.util.*;
import java.io.*;
public class Baekjoon9506 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            int sum = 0;
            List<Integer> li = new ArrayList<>();
            for(int i = 1; i < n; i++){
                if(n % i == 0){
                    sum += i;
                    li.add(i);
                }
            }
            if(sum != n) System.out.println(n + " is NOT perfect.");
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(n + " = ");
                for(int i = 0; i < li.size(); i++){
                    sb.append(li.get(i));
                    if(i != li.size() - 1) sb.append(" + ");
                }
                System.out.println(sb);
            }
        }
    }
}