import java.util.*;
import java.io.*;
public class Baekjoon1546 {
    static int n;
    static double max;
    static List<Double> li = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            double a = Double.parseDouble(st.nextToken());
            max = Math.max(max, a);
            li.add(a);
        }
        double sum = 0;
        for(int i = 0; i < n; i++){
            sum += li.get(i) / max * 100;
        }
        System.out.println(sum / n);
    }
}