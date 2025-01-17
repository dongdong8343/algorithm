import java.io.*;
import java.util.*;
public class BaekjoonRe2750 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> li = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(br.readLine());
            li.add(t);
        }

        Collections.sort(li);

        li.forEach(x -> System.out.println(x));
    }
}