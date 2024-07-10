import java.util.*;
import java.io.*;
public class Baekjoon10807_1 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-- > 0) {
            li.add(Integer.parseInt(st.nextToken()));
        }
        int x = Integer.parseInt(br.readLine());
        Collections.sort(li);
        int cnt = 0;
        for(int i = 0; i < li.size(); i++){
            if(li.get(i) > x) break;
            if(li.get(i) == x) cnt++;
        }
        System.out.println(cnt);
    }
}