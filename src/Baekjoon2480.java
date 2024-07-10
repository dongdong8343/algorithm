import java.util.*;
import java.io.*;
public class Baekjoon2480 {
    static int[] v = new int[7];
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pos = 0;
        for(int i = 0; i < 3; i++){
            li.add(Integer.parseInt(st.nextToken()));
            v[li.get(i)]++;
            if(v[li.get(i)] > 1) pos = li.get(i);
        }
        if(v[pos] == 3) System.out.println(10000 + pos * 1000);
        else if(v[pos] == 2) System.out.println(1000 + pos * 100);
        else{
            Collections.sort(li);
            System.out.println(li.get(2) * 100);
        }
    }
}