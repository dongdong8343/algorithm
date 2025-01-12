import java.io.*;
import java.util.*;
public class CtBook3_2 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> li = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int min = 987654321;
            for(int j = 0; j < m; j++){
                int t = Integer.parseInt(st.nextToken());
                min = Math.min(min, t);
            }
            li.add(min);
        }

        Collections.sort(li);

        System.out.println(li.get(li.size() - 1));
    }
}