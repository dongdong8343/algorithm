import java.util.*;
import java.io.*;
public class Baekjoon5073 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a + b + c == 0) break;
            List<Integer> li = new ArrayList<>();
            li.add(a); li.add(b); li.add(c);
            Collections.sort(li);
            if(li.get(2) >= li.get(0) + li.get(1)){
                System.out.println("Invalid");
            }
            else{
                if(a == b && b == c) System.out.println("Equilateral");
                else if(a != b && a != c && b != c) System.out.println("Scalene");
                else System.out.println("Isosceles");
            }
        }
    }
}