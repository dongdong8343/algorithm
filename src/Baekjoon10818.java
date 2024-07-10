import java.util.*;
import java.io.*;
public class Baekjoon10818 {
    static List<Integer> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        while(n-- > 0){
            li.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(li);
        System.out.println(li.get(0) + " " + li.get(li.size() - 1));
    }
}